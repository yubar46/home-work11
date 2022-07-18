package service;

import domain.Comment;
import repository.CommentRepository;
import repository.CommentRepositoryImpl;

public class CommentServiceImpl extends BaseServiceImpl<Comment,Long, CommentRepository> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }
}
