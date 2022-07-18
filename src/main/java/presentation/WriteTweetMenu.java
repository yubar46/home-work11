package presentation;

import context.ApplicationContext;
import domain.Tweet;

import java.util.Scanner;

public class WriteTweetMenu implements Menu {
    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        System.out.println("write your tweet");
        String s = console.nextLine();
        Tweet tweet = new Tweet(s, ApplicationContext.getInstance.getUser());
        ApplicationContext.getInstance.getTweets().add(tweet);
        ApplicationContext.getInstance.getTweetService().create(tweet);
        return new InsideMenu();
    }
}
