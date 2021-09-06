package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.Like;
import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;
import ir.maktab.repository.LikeRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LikeRepositoryImpl extends BaseEntityRepositoryImpl<Like, Long> implements LikeRepository {

    public LikeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Like> getEntityClass() {
        return Like.class;
    }

    @Override
    public Like getLikeByUserTweet(User user, Tweet tweet) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Like> query = criteriaBuilder.createQuery(Like.class);
        Root<Like> root = query.from(Like.class);
        Predicate userIdPredicate = criteriaBuilder.equal(root.get("userId"), user.getId());
        Predicate tweetIdPredicate = criteriaBuilder.equal(root.join("tweet").get("id"), tweet.getId());
        query.select(root).where(criteriaBuilder.and(userIdPredicate, tweetIdPredicate));
        try {
         return entityManager.createQuery(query).getSingleResult();
        }catch (Exception e) {
            return null;
        }
    }
}
