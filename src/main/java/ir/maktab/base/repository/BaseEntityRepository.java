package ir.maktab.base.repository;

import ir.maktab.base.domain.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseEntityRepository<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    Optional<E> findById(ID id);

    List<E> findAll();

    void delete(E e);

    boolean existsById(ID id);

    Long countAll();

    EntityManager getEntityManager();
}
