package pl.java.scalatech.cqrsRepo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.Optional;

import pl.java.scalatech.domains.AbstractEntity;

@NoRepositoryBean
public interface QueryRepo<T extends AbstractEntity, ID extends Serializable> extends Repository<T, ID> {
    Optional<T> findById(ID id);

    boolean existsById(ID id);

    long count();

    Page<T> findAll(Pageable pageable);

    Iterable<T> findAllById(Iterable<ID> ids);

    Iterable<T> findAll(Sort sort);

    T getOne(ID id);

    <S extends T> Iterable<S> findAll(Example<S> example);

    <S extends T> Iterable<S> findAll(Example<S> example, Sort sort);

}
