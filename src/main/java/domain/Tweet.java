package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tweet {
    @Id
    Long ID;
    String tweet;
    @ManyToOne
    User tweetOwner;
    @OneToMany
    List<Comment> comments = new ArrayList<>();
    @OneToMany
    List<User> likedUsers = new ArrayList<>();

    public Tweet() {
    }
    public Tweet(String tweet,User tweetOwner) {
        this.tweet = tweet;
        this.tweetOwner = tweetOwner;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public User getTweetOwner() {
        return tweetOwner;
    }

    public void setTweetOwner(User tweetOwner) {
        this.tweetOwner = tweetOwner;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(List<User> likedUsers) {
        this.likedUsers = likedUsers;
    }
}
