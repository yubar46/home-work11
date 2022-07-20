package repository;

import domain.Tweet;
import domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Tweet, Long> implements TweetRepository {
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

    @Override
    public List<Tweet> findUserTweets(User user) {
        List<Tweet> tweets = entityManager.createQuery
                ("select t from Tweet  t  where tweetOwner.id=:userId", Tweet.class).
                setParameter("userId", user.getId()).getResultList();
        return tweets;
    }

    public void deleteAllByUserId(Long id) {
        entityManager.createQuery("delete from Tweet where tweetOwner.id =:id")
                .setParameter("id", id).executeUpdate();
    }



}
