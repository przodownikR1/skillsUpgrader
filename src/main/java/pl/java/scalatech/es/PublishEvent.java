package pl.java.scalatech.es;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.users.domain.User;

@Slf4j
public class PublishEvent {

	private final ApplicationEventPublisher publisher;

	public PublishEvent(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void create() {
		publisher.publishEvent(new User());
	}

	@Async
	public void asynMethod() {
		log.info("running async method with thread '{}'", Thread.currentThread());
	}

	@Async
	public void publishUser(){
		publisher.publishEvent(new UserModifiedEvent(User.builder().login("przodownik").build()));
	}

	@Async
	public void publishUserImportant(){
		publisher.publishEvent(new UserModifiedEvent(User.builder().login("przodownik").build(),true));
	}


}