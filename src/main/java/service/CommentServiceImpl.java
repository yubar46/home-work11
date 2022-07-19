package service;

import domain.Comment;
import domain.User;
import repository.CommentRepository;
import repository.CommentRepositoryImpl;

public class CommentServiceImpl extends BaseServiceImpl<Comment, Long, CommentRepository> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }

    public Comment findByUserOwnerAndCommentId(User user, Long id) {
        return repository.findByUserOwnerAndCommentId(user, id);
    }

   public void deleteAllByUserId(Long id){
        repository.deleteAllByUserId(id);
   }
}
