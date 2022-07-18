package domain;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    Long id;
    @Column(length = 288)
    String comment;
    @ManyToOne
    User commentOwner;
}
