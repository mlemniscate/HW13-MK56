package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.Like;
import ir.maktab.repository.LikeRepository;
import ir.maktab.service.LikeService;

public class LikeServiceImpl extends BaseEntityServiceImpl<Like, Long, LikeRepository> implements LikeService {
    public LikeServiceImpl(LikeRepository repository) {
        super(repository);
    }
}
