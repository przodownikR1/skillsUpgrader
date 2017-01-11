package pl.java.scalatech.users.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.users.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    Optional<User> findByEmail(String email);

}
