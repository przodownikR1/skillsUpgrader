package pl.java.scalatech.tests.web2;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskService2Impl implements TaskService2 {


	@Override
	public String execute() {
		try {
			Thread.sleep(5000);
			log.info("Slow task executed");
			return "Task finished";
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}
}