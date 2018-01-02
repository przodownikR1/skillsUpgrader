package pl.java.scalatech.tests.web1;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.schedulers.Schedulers;
@RestController
@Slf4j
class ObservableController {

	@RequestMapping(value = "/web1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Observable<Map<String, String>> getMessage() {
		return Observable.fromCallable(() -> {
			log.info("Creating message");

			return Collections.singletonMap(
					"message",
					"Hello World!"
			);
		}).subscribeOn(Schedulers.computation());
	}
}