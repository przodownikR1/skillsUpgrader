package pl.java.scalatech.tests.web3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class ReactorController {

	@Autowired
	private ReactorService reactorService;

	@RequestMapping(value = "/web3/sync", method = RequestMethod.GET)
	public Order sync() {
		return reactorService.findAll();
	}

	@RequestMapping(value = "/web3/async", method = RequestMethod.GET)
	public DeferredResult<Order> async() {
		DeferredResult<Order> deferredResult = new DeferredResult<>();
		reactorService.findAllAsync().subscribe(result -> deferredResult.setResult(result), error -> deferredResult.setErrorResult(error));
		return deferredResult;
	}

	@RequestMapping(value = "/web3/javaAsync", method = RequestMethod.GET)
	public DeferredResult<Order> javaAsync() {
		DeferredResult<Order> deferredResult = new DeferredResult<>();
		reactorService.findAllJavaAsync().whenComplete((result, error) -> {
			if (error != null) deferredResult.setErrorResult(error);
			deferredResult.setResult(result);
		});
		return deferredResult;
	}

	@RequestMapping(value = "/web3/reactor", method = RequestMethod.GET)
	public DeferredResult<Order> reactor() {
		DeferredResult<Order> deferredResult = new DeferredResult<>();
		reactorService.findAllJavaAsync().whenComplete((result, error) -> {
			if (error != null) deferredResult.setErrorResult(error);
			deferredResult.setResult(result);
		});
		return deferredResult;
	}
}