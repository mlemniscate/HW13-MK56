package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.Like;
import ir.maktab.repository.LikeRepository;

import javax.persistence.EntityManager;

public class LikeRepositoryImpl extends BaseEntityRepositoryImpl<Like, Long> implements LikeRepository {

    public LikeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Like> getEntityClass() {
        return Like.class;
    }
}
