package service;

import domain.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

public class UserServiceImpl extends BaseServiceImpl<User,Long, UserRepository> implements  UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
