package ir.maktab.base.service.impl;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.base.repository.BaseEntityRepository;
import ir.maktab.base.service.BaseEntityService;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseEntityServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseEntityRepository<E, ID>> implements BaseEntityService<E, ID> {

    protected final R repository;

    public BaseEntityServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        repository.getEntityManager().getTransaction().begin();
        repository.save(e);
        repository.getEntityManager().getTransaction().commit();
        return e;
    }

    @Override
    public Optional<E> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(E e) {
        repository.getEntityManager().getTransaction().begin();
        repository.delete(e);
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }
}
