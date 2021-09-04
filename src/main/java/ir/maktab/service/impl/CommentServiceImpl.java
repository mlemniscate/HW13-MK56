package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.Comment;
import ir.maktab.repository.CommentRepository;
import ir.maktab.service.CommentService;

public class CommentServiceImpl extends BaseEntityServiceImpl<Comment, Long, CommentRepository> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }
}
