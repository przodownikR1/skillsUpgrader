package pl.java.scalatech.tasks.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.tasks.domain.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

    Optional<Task> findByName(String name);

}
