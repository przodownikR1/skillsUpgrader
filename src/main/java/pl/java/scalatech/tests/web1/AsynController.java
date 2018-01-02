package pl.java.scalatech.tests.web1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.RequestMapping;

public class AsynController {
private static final int THREADS_COUNT = 100;
private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
private final int DELAY = 1000;

@RequestMapping("/web1/sync")
String getSync() throws InterruptedException{
	Thread.sleep(DELAY);
	return "przodownik";
}


}
