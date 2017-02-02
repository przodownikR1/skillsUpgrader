package pl.java.scalatech.users.contoller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.java.scalatech.es.PublishEvent;
import pl.java.scalatech.users.domain.User;
import pl.java.scalatech.users.repo.UserQueryRepo;

@RestController
@RequestMapping("/users")
public class UserQueryController {

	private final UserQueryRepo userRepo;

	private final PublishEvent producer;

	public UserQueryController(UserQueryRepo userRepo, PublishEvent producer) {

		this.userRepo = userRepo;
		this.producer = producer;
	}

	@GetMapping("/")
	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	Page<User> getAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	@GetMapping("/prod")
	HttpEntity<Void> prod() {
		producer.publishUser();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/prodImportant")
	HttpEntity<Void> prodImportant() {
		producer.publishUserImportant();
		return ResponseEntity.ok().build();
	}

}
