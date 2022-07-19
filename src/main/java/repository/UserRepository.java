package repository;

import domain.Tweet;
import domain.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User,Long> {

    User findByUserName(String username);
    void deleteByUserId(Long id);

}
