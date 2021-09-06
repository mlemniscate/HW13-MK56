package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.domain.enums.LikeStatus;

import javax.persistence.*;

@Entity
@Table(name = Like.TABLE_NAME)
public class Like extends BaseEntity<Long> {
    public static final String TABLE_NAME = "likes";
    public static final String LIKE_STATUS = "like_status";
    public static final String USER_ID = "user_id";

    @Column(name = LIKE_STATUS, nullable = false)
    @Enumerated(EnumType.STRING)
    private LikeStatus likeStatus = LikeStatus.DISLIKE;

    @Column(name = USER_ID, nullable = false)
    private Long userId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    public Like() {
    }

    public Like(LikeStatus likeStatus, Long userId) {
        this.likeStatus = likeStatus;
        this.userId = userId;
    }

    public LikeStatus getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(LikeStatus likeStatus) {
        this.likeStatus = likeStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeStatus=" + likeStatus +
                ", userId=" + userId +
                '}';
    }
}
