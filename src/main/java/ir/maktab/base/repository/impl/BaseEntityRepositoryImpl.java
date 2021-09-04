package ir.maktab.base.repository.impl;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.base.repository.BaseEntityRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseEntityRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseEntityRepository<E, ID> {

    private final EntityManager entityManager;

    public BaseEntityRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract Class<E> getEntityClass();

    @Override
    public E save(E e) {
        if(e.getId() == null) {
            entityManager.persist(e);
            return e;
        } else {
            return entityManager.merge(e);
        }
    }

    @Override
    public Optional<E> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public List<E> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<E> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void delete(E e) {
        entityManager.remove(e);
    }

    @Override
    public boolean existsById(ID id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<E> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.select(criteriaBuilder.count(root)).where(criteriaBuilder.equal(root.get("id"), id));
        return entityManager.createQuery(criteriaQuery).getSingleResult() > 0;
    }

    @Override
    public Long countAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<E> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.select(criteriaBuilder.count(root));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
