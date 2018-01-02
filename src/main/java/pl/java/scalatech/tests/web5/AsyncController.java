package pl.java.scalatech.tests.web5;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class AsyncController {


	private final AtomicLong l = new AtomicLong();
	@Autowired TaskService taskService;

	@RequestMapping(value = "/web5/async", method = RequestMethod.GET)
	public Map<String, String> callAsync() {

		log.info("Request received");
		taskService.async();
		Map<String, String> result = Collections.singletonMap(
			"msg", "Task finished " + l.incrementAndGet() + " times."
		);
		log.info("Servlet thread released");

		return result;
	}
}