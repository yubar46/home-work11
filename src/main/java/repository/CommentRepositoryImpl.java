package repository;

import domain.Comment;
import domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment, Long> implements CommentRepository {
    public CommentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class getClassObject() {
        return Comment.class;
    }

    public Comment findByUserOwnerAndCommentId(User user, Long id) {
        List<Comment> comment = entityManager.createQuery(" select c from Comment  c where commentOwner.id=:userId and id=:id", Comment.class)
                .setParameter("userId", user.getId())
                .setParameter("id", id).getResultList();
        if (!comment.isEmpty()) return comment.get(0);
        else return null;
    }

    public void deleteAllByUserId(Long id) {
        entityManager.createQuery("delete from Comment where commentOwner.id =:id")
                .setParameter("id", id).executeUpdate();
    }

}
