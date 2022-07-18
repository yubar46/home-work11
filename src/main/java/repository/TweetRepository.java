package repository;

import domain.Tweet;

import java.util.List;

public interface TweetRepository extends BaseRepository<Tweet,Long> {


    List<Tweet> showAllTweets();
}
