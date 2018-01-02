package pl.java.scalatech.tests.web2;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AsyncCallableController2 {

	private final TaskService2 taskService;

	@Autowired
	public AsyncCallableController2(TaskService2 taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/web2/callable", method = RequestMethod.GET, produces = "text/html")
	public Callable<String> executeSlowTask() {
		log.info("Request received");
		Callable<String> callable = taskService::execute;
		log.info("Servlet thread released");

		return callable;
	}
}