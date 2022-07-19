package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tweet;
    @ManyToOne
    User tweetOwner;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tweet_id")
    List<Comment> comments = new ArrayList<>();
    @ManyToMany(mappedBy ="likedTweets" )
    List<User> likedUsers = new ArrayList<>();

    public Tweet() {
    }

    public Tweet(String tweet, User tweetOwner) {
        this.tweet = tweet;
        this.tweetOwner = tweetOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ID) {
        this.id = ID;
    }


    public String toString() {
        return String.format(" tweet id: %d %s : %n %s %n liked by %d people %n ",
                id, tweetOwner.getUserName(), getTweet(), likedUsers.size());

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
