package pl.java.scalatech.cqrsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import pl.java.scalatech.domains.AbstractEntity;

@NoRepositoryBean
public interface CommandRepo<T extends AbstractEntity> extends JpaRepository<T, Long>{

}
