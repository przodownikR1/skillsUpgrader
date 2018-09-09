package pl.java.scalatech.users.contoller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import pl.java.scalatech.es.PublishEvent;
import pl.java.scalatech.users.domain.User;
import pl.java.scalatech.users.repo.UserQueryRepo;
import pl.java.scalatech.users.repo.UserQueryRxRepo;

@RestController
@RequestMapping("/users")
public class UserQueryController {

	private final UserQueryRepo userRepo;

	private final UserQueryRxRepo userRxRepo;

	private final PublishEvent producer;

	public UserQueryController(UserQueryRepo userRepo, PublishEvent producer,UserQueryRxRepo userRepoRx) {

		this.userRepo = userRepo;
		this.producer = producer;
		this.userRxRepo = userRepoRx;
	}
	
	  @RequestMapping(method = RequestMethod.OPTIONS)
	    ResponseEntity<?> options() {
	        return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.HEAD, HttpMethod.OPTIONS, HttpMethod.PUT, HttpMethod.DELETE).build();
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

	@GetMapping("/login/{login}")
	DeferredResult<User> getUserByLogin(@PathVariable String login){

				DeferredResult<User> deffered = new DeferredResult<>();
				userRxRepo.findByLogin(login).subscribe(t -> deffered.setResult(t.get()));

	return deffered;
	}


	@GetMapping("/prodImportant")
	HttpEntity<Void> prodImportant() {
		producer.publishUserImportant();
		return ResponseEntity.ok().build();
	}

}
