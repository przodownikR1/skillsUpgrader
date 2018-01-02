package pl.java.scalatech.tests.web1;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.function.Supplier;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;

import rx.Observable;

@Controller
@RequestMapping("/web1")
public class SumController {

	SecureRandom random = new SecureRandom();

	@RequestMapping(value = "/init")
	public ResponseEntity<Void> init() {
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "/norx1")
	public ResponseEntity<BigDecimal> simpleSync() {
		return ResponseEntity.ok(getA());
	}

	@RequestMapping(value = "/rx1")
	public DeferredResult<ResponseEntity<BigDecimal>> simpleAsync() {
		DeferredResult<ResponseEntity<BigDecimal>> result = new DeferredResult<>();
		Observable.create(emit(this::getA))
			.map(n -> ResponseEntity.ok(n))
			.subscribe(re -> result.setResult(re));
		return result;
	}

	@RequestMapping(value = "/norx2")
	public ResponseEntity<BigDecimal> sync() {
		return ResponseEntity.ok(getA().add(getB()));
	}

	@RequestMapping(value = "/rx2")
	public DeferredResult<ResponseEntity<BigDecimal>> async() {
		DeferredResult<ResponseEntity<BigDecimal>> result = new DeferredResult<>();
		Observable.create(emit(this::getA))
				.zipWith(Observable.create(emit(this::getB)), (x, y) -> x.add(y))
				.map(n -> ResponseEntity.ok(n))
				.subscribe(re -> result.setResult(re));
		return result;
	}


	private Observable.OnSubscribe<BigDecimal> emit(Supplier<? extends BigDecimal> p) {
		return s -> {
			s.onNext(p.get());
			s.onCompleted();
		};
	}

	private BigDecimal getA() {
		sleep();
		return BigDecimal.valueOf(500);
	}

	private BigDecimal getB() {
		sleep();
		return BigDecimal.valueOf(300);
	}

	private void sleep() {
		try { Thread.sleep(10 + random.nextInt(10)); } catch (InterruptedException e) { }
	}
}
/*

wrk -c1000 -t10 -d10s http://localhost:8080/init
wrk -c1000 -t10 -d10s http://localhost:8080/norx1
wrk -c1000 -t10 -d10s http://localhost:8080/rx1
wrk -c1000 -t10 -d10s http://localhost:8080/norx2
wrk -c1000 -t10 -d10s http://localhost:8080/rx2

*/