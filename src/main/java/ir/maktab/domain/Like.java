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

    @Column(name = USER_ID, nullable = false, unique = true)
    private Long userId;

    public Like() {
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
}
