package service;

import domain.Tweet;

import java.util.List;

public interface TweetService extends BaseService<Tweet,Long> {
    List<Tweet> showAllTweets();

}
