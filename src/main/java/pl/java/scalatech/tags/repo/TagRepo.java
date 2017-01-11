package pl.java.scalatech.tags.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.tags.domain.Tag;

public interface TagRepo extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);
}
