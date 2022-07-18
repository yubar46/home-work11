package repository;

import domain.Comment;

import javax.persistence.EntityManager;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment,Long> implements CommentRepository {
    public CommentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class getClassObject() {
        return Comment.class;
    }
}
