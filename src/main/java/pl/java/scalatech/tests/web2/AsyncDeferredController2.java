package pl.java.scalatech.tests.web2;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AsyncDeferredController2 {

	private final TaskService2 taskService;

	@Autowired
	public AsyncDeferredController2(TaskService2 taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/web2/deferred", method = RequestMethod.GET, produces = "text/html")
	public DeferredResult<String> executeSlowTask() {
		log.info("Request received");
		DeferredResult<String> deferredResult = new DeferredResult<>();
		CompletableFuture.supplyAsync(taskService::execute)
				.whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
		log.info("Servlet thread released");

		return deferredResult;
	}
}