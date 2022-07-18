package context;

import domain.Tweet;
import domain.User;
import repository.*;
import service.*;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ApplicationContext {

    public static ApplicationContext getInstance = new ApplicationContext();
    private EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    private UserRepository userRepository = new UserRepositoryImpl(entityManager);
    private TweetRepository tweetRepository = new TweetRepositoryImpl(entityManager);
    private CommentRepository commentRepository = new CommentRepositoryImpl(entityManager);

    private UserService userService = new UserServiceImpl(userRepository);
    private TweetService tweetService = new TweetServiceImpl(tweetRepository);
    private CommentService commentService = new CommentServiceImpl(commentRepository);

    private User user ;
    private List<Tweet> tweets;


    private ApplicationContext() {

    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TweetRepository getTweetRepository() {
        return tweetRepository;
    }

    public void setTweetRepository(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public TweetService getTweetService() {
        return tweetService;
    }

    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
