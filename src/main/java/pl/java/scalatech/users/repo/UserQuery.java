package pl.java.scalatech.users.repo;

import java.util.Optional;

import pl.java.scalatech.users.domain.User;

public interface UserQuery {
	Optional<User> findByLogin(String login);

	Optional<User> findByEmail(String email);
}