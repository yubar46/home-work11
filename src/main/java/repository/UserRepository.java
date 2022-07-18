package repository;

import domain.User;

public interface UserRepository extends BaseRepository<User,Long> {

    User findByUserName(String username);
}
