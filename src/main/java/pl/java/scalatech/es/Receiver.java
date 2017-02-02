package pl.java.scalatech.es;

import java.time.LocalDateTime;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.config.Task;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.skills.domain.Skill;
import pl.java.scalatech.users.domain.User;

@Slf4j
public class Receiver {

	@EventListener
	void handleSync(User event) {
		log.info("thread '{}' handling '{}' event", Thread.currentThread(), event);
	}

	@Async
	@EventListener
	void handleAsync(User user) {
		log.info("thread '{}' handling '{}' event", Thread.currentThread(), user);
	}

	@Async
	@EventListener
	void handleAsync(Skill skill) {
		log.info("thread '{}' handling '{}' event", Thread.currentThread(), skill);
	}

	@Async
	@EventListener
	void handleAsync(Task task) {
		log.info("thread '{}' handling '{}' event", Thread.currentThread(), task);
	}

	@TransactionalEventListener
	public void handleAfterCommit(User event){
		log.info("create new user : {} thread '{}''",event, Thread.currentThread());
	}

	@Async
	@EventListener
	public MyUser handleContextEvent(User user) {
		System.out.println("event received: " + user);
		return new MyUser(LocalDateTime.now());
	}
	@Async
	@EventListener
	public void handleContextEvent(MyUser user) {
		System.out.println("event received: " + user);
	}

	@EventListener(condition="#userModifiedEvent.importantChange")
	public void blogModified(UserModifiedEvent userModifiedEvent) {
		log.info("+++  {}",userModifiedEvent);

	}

}

