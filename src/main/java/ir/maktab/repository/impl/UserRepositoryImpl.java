package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User, Long> implements UserRepository {



    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public List<String> findAllUsernames() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Root<User> root = query.from(User.class);
        query.select(root.get("username"));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User findByUsernamePassword(String username, String password) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Predicate predicateUsername = criteriaBuilder.equal(root.get("username"), username);
        Predicate predicatePassword = criteriaBuilder.equal(root.get("password"), password);
        query.select(root).where(criteriaBuilder.and(predicateUsername, predicatePassword));
        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(criteriaBuilder.equal(root.get("username"), username));
        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
}
