package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.Like;
import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;
import ir.maktab.domain.enums.LikeStatus;
import ir.maktab.repository.LikeRepository;
import ir.maktab.service.LikeService;
import ir.maktab.util.ApplicationContext;

import java.util.Objects;

public class LikeServiceImpl extends BaseEntityServiceImpl<Like, Long, LikeRepository> implements LikeService {
    public LikeServiceImpl(LikeRepository repository) {
        super(repository);
    }

    @Override
    public void likeATweet(User user, Tweet tweet) {
        Like likedStatusByUserTweet = repository.getLikeByUserTweet(user, tweet);
        if(Objects.isNull(likedStatusByUserTweet)){
            likedStatusByUserTweet = new Like(LikeStatus.LIKE, user.getId());
            tweet.addLike(likedStatusByUserTweet);
            ApplicationContext.getTweetService().save(tweet);
        } else {
            tweet.getLikes().remove(likedStatusByUserTweet);
            ApplicationContext.getTweetService().save(tweet);
            delete(likedStatusByUserTweet);
        }
    }
}
