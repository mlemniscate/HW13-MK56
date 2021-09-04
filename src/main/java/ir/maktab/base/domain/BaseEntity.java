package ir.maktab.base.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable {

    public static final String IS_DELETED = "is_deleted";

    @Id
    @GeneratedValue
    private ID id;

    @Column(name = IS_DELETED)
    private boolean isDeleted;

    public BaseEntity() {
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
