package pl.java.scalatech.users.events;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ReceiverUser {

	@Async
	@EventListener(classes={UserCreateEvent.class})
	void handleCreateAsync(UserCreateEvent create) {
		log.info("thread '{}' handling '{}' create", Thread.currentThread(), create);
	}

	@Async
	@EventListener(classes={UserChangePasswordEvent.class})
	void handlePasswordChanged(UserChangePasswordEvent event) {
		log.info("thread '{}' handling '{}' passwordChanged", Thread.currentThread(), event);
	}

	@Async
	@EventListener(classes={UserModificationEvent.class})
	void handleUserModificationAsync(UserModificationEvent event) {
		log.info("thread '{}' handling '{}' modification", Thread.currentThread(), event);
	}
	@Async
	@EventListener(classes={UserRemoveEvent.class})
	void handleUserRemoveAsync(UserRemoveEvent event) {
		log.info("thread '{}' handling '{}' removed", Thread.currentThread(), event);
	}
}