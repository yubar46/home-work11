package presentation;

import context.ApplicationContext;
import domain.Comment;
import domain.Tweet;

import java.util.Scanner;

public class NewCommentMenu implements Menu {
    Scanner console = new Scanner(System.in);
    @Override
    public Menu action() {
        System.out.println("enter tweet id");
        Long id = console.nextLong();
        if (ApplicationContext.getInstance.getTweetService().read(id)!=null){
            Tweet tweet = ApplicationContext.getInstance.getTweetService().read(id);
            String comment = console.nextLine();
            Comment newComment = new Comment(comment,ApplicationContext.getInstance.getUser());
            tweet.getComments().add(newComment);
            ApplicationContext.getInstance.getTweetService().update(tweet);
            ApplicationContext.getInstance.setTweets(ApplicationContext.getInstance.getTweetService().showAllTweets());
            System.out.println("comment successfully added");
        }
        return new InsideMenu();

    }
}
