package repository;

import domain.Tweet;

import javax.persistence.EntityManager;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Tweet,Long> implements TweetRepository {
    public TweetRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class getClassObject() {
        return Tweet.class;
    }
}
