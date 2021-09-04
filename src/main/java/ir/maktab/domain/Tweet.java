package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Tweet.TABLE_NAME)
public class Tweet extends BaseEntity<Long> {

    public static final String TABLE_NAME = "tweets";
    public static final String TEXT = "text";
    public static final String CREATED_TIME = "created_time";
    public static final String LAST_UPDATED_TIME = "last_updated_time";

    @Column(name = TEXT, columnDefinition = "TEXT", length = 280)
    private String text;

    @Column(name = CREATED_TIME)
    private Date createdTime;

    @Column(name = LAST_UPDATED_TIME)
    private Date lastUpdatedTime;

    @OneToMany
    @JoinColumn(name = "tweet_id")
    private List<Like> likes;

    @OneToMany
    @JoinColumn(name = "tweet_id")
    private List<Comment> comments;

    public Tweet() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
