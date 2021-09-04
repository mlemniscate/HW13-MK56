package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.Tweet;
import ir.maktab.repository.TweetRepository;

import javax.persistence.EntityManager;

public class TweetRepositoryImpl extends BaseEntityRepositoryImpl<Tweet, Long> implements TweetRepository {

    protected TweetRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Tweet> getEntityClass() {
        return Tweet.class;
    }
}
