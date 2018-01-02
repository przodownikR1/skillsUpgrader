package pl.java.scalatech.tests.web2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BlockingController2 {

	private final TaskService2 taskService;

	@Autowired
	public BlockingController2(TaskService2 taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/web2/block", method = RequestMethod.GET, produces = "text/html")
	public String executeSlowTask() {
		log.info("Request received");
		String result = taskService.execute();
		log.info("Servlet thread released");

		return result;
	}
}