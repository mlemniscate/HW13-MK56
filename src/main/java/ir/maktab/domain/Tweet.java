package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tweet")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tweet_id")
    private List<Comment> comments = new ArrayList<>();

    public Tweet() {
    }

    public Tweet(String text, Date createdTime) {
        this.text = text;
        this.createdTime = createdTime;
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

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addLike(Like like) {
        likes.add(like);
        like.setTweet(this);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                ", createdTime=" + createdTime +
                ", lastUpdatedTime=" + lastUpdatedTime +
                '}' + "\n";
    }
}
