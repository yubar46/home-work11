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
            ApplicationContext.getInstance.getCommentService().deleteAllByUserId
                    (ApplicationContext.getInstance.getUser().getId());
            ApplicationContext.getInstance.getTweetService().deleteAllByUserId
                    (ApplicationContext.getInstance.getUser().getId());
            repository.deleteByUserId(id);
            ApplicationContext.getInstance.getEntityManager().getTransaction().commit();

        } catch (Exception e) {
            ApplicationContext.getInstance.getEntityManager().getTransaction().rollback();

            throw e;
        }

    }
}
