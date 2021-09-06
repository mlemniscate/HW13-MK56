package ir.maktab.repository;

import ir.maktab.base.repository.BaseEntityRepository;
import ir.maktab.domain.Like;
import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;

public interface LikeRepository extends BaseEntityRepository<Like, Long> {
    Like getLikeByUserTweet(User user, Tweet tweet);
}
