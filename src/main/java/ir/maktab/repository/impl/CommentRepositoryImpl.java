package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab.domain.Comment;
import ir.maktab.repository.CommentRepository;

import javax.persistence.EntityManager;

public class CommentRepositoryImpl extends BaseEntityRepositoryImpl<Comment, Long> implements CommentRepository {

    public CommentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
