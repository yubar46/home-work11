package repository;

import domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<User> getClassObject() {
        return User.class;
    }

    @Override
    public User findByUserName(String username) {
        List<User> users = entityManager.createQuery("select u from  User  u where u.userName= :username ", User.class)
                .setParameter("username", username).getResultList();
        if (!users.isEmpty()) return users.get(0);
        else return null;
    }

    @Override
    public void deleteByUserId(Long id) {
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id",id)
                .executeUpdate();
    }
}
