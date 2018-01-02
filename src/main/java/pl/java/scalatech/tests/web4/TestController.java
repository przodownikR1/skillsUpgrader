package pl.java.scalatech.tests.web4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import rx.Observable;

@RestController
public class TestController {

@Autowired
TestService service;

@RequestMapping("/helloAsync")
public DeferredResult<String> hello() {
	Observable<String> hello = service.hello();
	DeferredResult<String> deffered = new DeferredResult<>(100l);
	hello.subscribe(m -> deffered.setResult(m), e -> deffered.setErrorResult(e));
	return deffered;
}

@RequestMapping("/getAMessageObsAsync")
public DeferredResult<String> getAMessageAsync() {
	Observable<String> o = service.getAMessageObs();
	DeferredResult<String> deffered = new DeferredResult<>(100l);
	o.subscribe(m -> deffered.setResult(m), e -> deffered.setErrorResult(e));
	return deffered;
}
}