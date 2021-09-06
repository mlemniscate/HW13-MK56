package ir.maktab.service;

import ir.maktab.base.service.BaseEntityService;
import ir.maktab.domain.Like;
import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;

public interface LikeService extends BaseEntityService<Like, Long> {
    void likeATweet(User user, Tweet tweet);
}
