package domain;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 288)
    String comment;
    @ManyToOne
    User commentOwner;


    public Comment() {
    }

    public Comment(String comment, User user) {
        this.comment = comment;
        this.commentOwner = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return String.format("%s: %s %n comment id: %d", commentOwner.getUserName(), comment, id);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(User commentOwner) {
        this.commentOwner = commentOwner;
    }
}
