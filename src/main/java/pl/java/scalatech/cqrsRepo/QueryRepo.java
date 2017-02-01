package pl.java.scalatech.cqrsRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domains.AbstractEntity;

public interface QueryRepo<T extends AbstractEntity> extends JpaRepository<T, Long>{

}
