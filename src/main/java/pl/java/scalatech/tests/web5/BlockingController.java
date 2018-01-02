package pl.java.scalatech.tests.web5;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BlockingController {

	@Autowired TaskService taskService;

	@RequestMapping(value = "/web5/block", method = RequestMethod.GET)
	public Map<String, String> executeSlowTask() {

		log.info("Request received");
		Map<String, String> result = taskService.execute();
		log.info("Servlet thread released");

		return result;
	}
}