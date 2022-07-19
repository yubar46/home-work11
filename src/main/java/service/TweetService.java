package service;

import domain.Tweet;
import domain.User;

import java.util.List;

public interface TweetService extends BaseService<Tweet, Long> {
    List<Tweet> showAllTweets();

    List<Tweet> findUserTweets(User user);

    void deleteAllByUserId(Long id);


}
