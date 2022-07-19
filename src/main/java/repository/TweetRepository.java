package repository;

import domain.Tweet;
import domain.User;

import java.util.List;

public interface TweetRepository extends BaseRepository<Tweet, Long> {


    List<Tweet> showAllTweets();

    List<Tweet> findUserTweets(User user);

    void deleteAllByUserId(Long id);


}
