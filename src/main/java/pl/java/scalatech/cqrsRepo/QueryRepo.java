package pl.java.scalatech.cqrsRepo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import pl.java.scalatech.domains.AbstractEntity;

@NoRepositoryBean
public interface QueryRepo<T extends AbstractEntity, ID extends Serializable> extends Repository<T, ID> {

	T findOne(ID id);

	boolean exists(ID id);

	long count();

	Page<T> findAll(Pageable pageable);

	List<T> findAll();

	List<T> findAll(Sort sort);

	List<T> findAll(Iterable<ID> ids);

	T getOne(ID id);

	<S extends T> List<S> findAll(Example<S> example);

	<S extends T> List<S> findAll(Example<S> example, Sort sort);

}
