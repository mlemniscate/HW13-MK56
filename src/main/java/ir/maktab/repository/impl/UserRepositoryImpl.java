package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User, Long> implements UserRepository {

    protected UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
