package service;

import context.ApplicationContext;
import domain.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public void delete(Long id) {

        try {

            ApplicationContext.getInstance.getEntityManager().getTransaction().begin();

            repository.delete(id);
            ApplicationContext.getInstance.getEntityManager().getTransaction().commit();

        } catch (Exception e) {
            ApplicationContext.getInstance.getEntityManager().getTransaction().rollback();

            throw e;
        }

    }
}
