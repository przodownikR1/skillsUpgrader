package pl.java.scalatech.users.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import pl.java.scalatech.users.domain.User;
import rx.Observable;
@Repository
public class UserQueryRxRepo {

	private final UserQueryRepo userQueryRepo;

	public UserQueryRxRepo(UserQueryRepo repo) {
	this.userQueryRepo = repo;
	}

	public Observable<Optional<User>> findByLogin(String login) {
		return Observable.fromCallable(()-> userQueryRepo.findByLogin(login));
	}

	public Observable<Optional<User>> findByEmail(String email) {
		return Observable.fromCallable(()-> userQueryRepo.findByEmail(email));
	}

}
