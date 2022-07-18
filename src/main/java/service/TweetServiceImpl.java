package service;

import domain.Tweet;
import repository.TweetRepository;
import repository.TweetRepositoryImpl;

public class TweetServiceImpl extends BaseServiceImpl<Tweet,Long, TweetRepository> implements  TweetService {

    public TweetServiceImpl(TweetRepository repository) {
        super(repository);
    }
}
