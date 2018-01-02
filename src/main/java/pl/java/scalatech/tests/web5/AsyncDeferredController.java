package pl.java.scalatech.tests.web5;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class AsyncDeferredController {


	@Autowired TaskService taskService;

	@RequestMapping(value = "/web5/deferred", method = RequestMethod.GET)
	public DeferredResult<Map<String, String>> executeSlowTask() {

		log.info("Request received");
		DeferredResult<Map<String, String>> deferredResult = new DeferredResult<>();
		CompletableFuture.supplyAsync(taskService::execute)
			.whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
		log.info("Servlet thread released");

		return deferredResult;
	}
}