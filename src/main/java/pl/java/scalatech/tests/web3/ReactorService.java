package pl.java.scalatech.tests.web3;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rx.Observable;
import rx.schedulers.Schedulers;

//@Service
@Slf4j
public class ReactorService {

	private static ExecutorService rxJavaExecutorService = Executors.newFixedThreadPool(4);

	@Autowired
	private AsyncTaskExecutor asyncTaskExecutor;

	// sync
	public Order findAll() {
		return generateOrder();
	}

	// async (rxjava)
	public Observable<Order> findAllAsync() {
		return Observable.<Order>create(subscriber -> {
			subscriber.onNext(generateOrder());
			subscriber.onCompleted();
		}).subscribeOn(Schedulers.from(rxJavaExecutorService));
	}

	// async (jdk8)
	public CompletableFuture<Order> findAllJavaAsync() {
		return CompletableFuture.supplyAsync(() -> {
			return generateOrder();
		}, asyncTaskExecutor);
	}


	private Order generateOrder() {
		Random random = new Random();
		ThreadUtils.delay(2000);

		Trade trade = new Trade(random.nextLong());
		trade.setPrice(100000f);
		trade.setQuantity(50000);
		trade.setSymbol("Mac Book");
		trade.setType(Type.BUY);

		Order order = new Order(random.nextLong());
		order.setTrade(trade);
		order.setTimestamp(System.currentTimeMillis());

		return order;
	}
}