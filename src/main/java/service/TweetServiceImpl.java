package service;

import domain.Tweet;
import domain.User;
import repository.TweetRepository;
import repository.TweetRepositoryImpl;

import java.util.List;

public class TweetServiceImpl extends BaseServiceImpl<Tweet, Long, TweetRepository> implements TweetService {

    public TweetServiceImpl(TweetRepository repository) {
        super(repository);
    }

    @Override
    public List<Tweet> showAllTweets() {
        return repository.showAllTweets();
    }

    public List<Tweet> findUserTweets(User user) {
        return repository.findUserTweets(user);
    }

    public void deleteAllByUserId(Long id) {
        repository.beginTransaction();
        repository.deleteAllByUserId(id);
        repository.commitTransaction();
    }



}
