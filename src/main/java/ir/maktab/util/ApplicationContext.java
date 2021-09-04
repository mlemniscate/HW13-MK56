package ir.maktab.util;

import ir.maktab.repository.CommentRepository;
import ir.maktab.repository.LikeRepository;
import ir.maktab.repository.TweetRepository;
import ir.maktab.repository.UserRepository;
import ir.maktab.repository.impl.CommentRepositoryImpl;
import ir.maktab.repository.impl.LikeRepositoryImpl;
import ir.maktab.repository.impl.TweetRepositoryImpl;
import ir.maktab.repository.impl.UserRepositoryImpl;
import ir.maktab.service.CommentService;
import ir.maktab.service.LikeService;
import ir.maktab.service.TweetService;
import ir.maktab.service.UserService;
import ir.maktab.service.impl.CommentServiceImpl;
import ir.maktab.service.impl.LikeServiceImpl;
import ir.maktab.service.impl.TweetServiceImpl;
import ir.maktab.service.impl.UserServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final UserRepository USER_REPOSITORY;
    private static final TweetRepository TWEET_REPOSITORY;
    private static final LikeRepository LIKE_REPOSITORY;
    private static final CommentRepository COMMENT_REPOSITORY;

    private static final UserService USER_SERVICE;
    private static final TweetService TWEET_SERVICE;
    private static final LikeService LIKE_SERVICE;
    private static final CommentService COMMENT_SERVICE;

    static {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        USER_REPOSITORY = new UserRepositoryImpl(entityManager);
        USER_SERVICE = new UserServiceImpl(USER_REPOSITORY);
        TWEET_REPOSITORY = new TweetRepositoryImpl(entityManager);
        TWEET_SERVICE = new TweetServiceImpl(TWEET_REPOSITORY);
        LIKE_REPOSITORY = new LikeRepositoryImpl(entityManager);
        LIKE_SERVICE = new LikeServiceImpl(LIKE_REPOSITORY);
        COMMENT_REPOSITORY = new CommentRepositoryImpl(entityManager);
        COMMENT_SERVICE = new CommentServiceImpl(COMMENT_REPOSITORY);
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

    public static TweetService getTweetService() {
        return TWEET_SERVICE;
    }

    public static LikeService getLikeService() {
        return LIKE_SERVICE;
    }

    public static CommentService getCommentService() {
        return COMMENT_SERVICE;
    }
}
