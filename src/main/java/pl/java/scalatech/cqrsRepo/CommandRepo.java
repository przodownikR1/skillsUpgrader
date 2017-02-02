package pl.java.scalatech.cqrsRepo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import pl.java.scalatech.domains.AbstractEntity;

@NoRepositoryBean
public interface CommandRepo<T extends AbstractEntity, ID extends Serializable> extends Repository<T, ID> {
	<S extends T> S save(S entity);

	void delete(ID id);

	void delete(T entity);

	void delete(Iterable<? extends T> entities);

	void deleteAll();

	<S extends T> List<S> save(Iterable<S> entities);

	void flush();

	<S extends T> S saveAndFlush(S entity);

	void deleteInBatch(Iterable<T> entities);

	void deleteAllInBatch();

}
