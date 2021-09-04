package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = Comment.TABLE_NAME)
public class Comment extends BaseEntity<Long> {
    public static final String TABLE_NAME = "comments";

    public static final String TEXT = "text";
    public static final String CREATED_TIME = "created_time";
    public static final String LAST_UPDATED_TIME = "last_updated_time";
    public static final String USER_ID = "user_id";

    @Column(name = TEXT)
    private String text;

    @Column(name = CREATED_TIME)
    private Date createdTime;

    @Column(name = LAST_UPDATED_TIME)
    private Date lastUpdatedTime;

    @Column(name = USER_ID, nullable = false, unique = true)
    private Long userId;

    public Comment() {
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
