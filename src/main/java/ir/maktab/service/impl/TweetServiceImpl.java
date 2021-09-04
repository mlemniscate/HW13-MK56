package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.Tweet;
import ir.maktab.repository.TweetRepository;
import ir.maktab.service.TweetService;

public class TweetServiceImpl extends BaseEntityServiceImpl<Tweet, Long, TweetRepository> implements TweetService {
    public TweetServiceImpl(TweetRepository repository) {
        super(repository);
    }
}
