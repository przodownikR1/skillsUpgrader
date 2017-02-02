package pl.java.scalatech.users.repo;

import java.util.Optional;

import pl.java.scalatech.cqrsRepo.QueryRepo;
import pl.java.scalatech.users.domain.User;

public interface UserQueryRepo extends QueryRepo<User, Long>{

	Optional<User> findByLogin(String login);

	Optional<User> findByEmail(String email);

}
