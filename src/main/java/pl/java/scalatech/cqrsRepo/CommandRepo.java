package pl.java.scalatech.cqrsRepo;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

import pl.java.scalatech.domains.AbstractEntity;

@NoRepositoryBean
public interface CommandRepo<T extends AbstractEntity, ID extends Serializable> extends Repository<T, ID> {

	<S extends T> S save(S entity);

	void deleteById(ID id);

    void delete(T entity);

    void deleteAll(Iterable<T> entities);

    void deleteAll();

	void flush();

	<S extends T> S saveAndFlush(S entity);

	void deleteInBatch(Iterable<T> entities);

	void deleteAllInBatch();

}
