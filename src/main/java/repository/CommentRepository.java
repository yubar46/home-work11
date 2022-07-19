package repository;

import domain.Comment;
import domain.User;

public interface CommentRepository extends BaseRepository<Comment, Long> {

    Comment findByUserOwnerAndCommentId(User user, Long id);
    void deleteAllByUserId(Long id);

}
