package pl.java.scalatech.tests.web5;

import java.util.Collections;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskService {


	public Map<String, String> execute() {
		try {
			Thread.sleep(5000);
			log.info("Slow task executed");
			return Collections.singletonMap("msg", "Task finished");
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}

	@Async
	public void async() {
		try {
			Thread.sleep(5000);
			log.info("Slow task executed by @Async.");
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}
}