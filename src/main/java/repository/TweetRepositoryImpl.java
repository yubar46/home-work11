package repository;

import domain.Tweet;

import javax.persistence.EntityManager;
import java.util.List;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Tweet,Long> implements TweetRepository {
    public TweetRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class getClassObject() {
        return Tweet.class;
    }

    @Override
    public List<Tweet> showAllTweets() {
        List<Tweet> tweets = entityManager.createQuery
                ("select t from Tweet  t ", Tweet.class).getResultList();
      return tweets;

    }
}
