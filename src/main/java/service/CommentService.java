package service;

import domain.Comment;
import domain.User;

public interface CommentService extends BaseService<Comment, Long> {
    Comment findByUserOwnerAndCommentId(User user, Long id);
    void deleteAllByUserId(Long id);
}
