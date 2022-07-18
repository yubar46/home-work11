package repository;

import domain.User;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends  BaseRepositoryImpl<User,Long> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<User> getClassObject() {
        return User.class;
    }
}
