package presentation;

import context.ApplicationContext;
import domain.Tweet;
import domain.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LikeTweetMenu implements Menu {
    Scanner console = new Scanner(System.in);

    @Override
    public Menu action() {
        System.out.println("enter your tweet ID");
        long select;
        try {
            select = console.nextInt();
        }catch (InputMismatchException exception){
            System.out.println("enter correct number");
            return new LikeTweetMenu();


        }
        Tweet tweet;
        boolean isLiked = false;
        if (ApplicationContext.getInstance.getTweetService().read(select) != null) {
            tweet = ApplicationContext.getInstance.getTweetService().read(select);
            for (User user : tweet.getLikedUsers()) {
                if (user.getUserName().equals(ApplicationContext.getInstance.getUser().getUserName())) {
                    tweet.getLikedUsers().remove(ApplicationContext.getInstance.getUser());
                    ApplicationContext.getInstance.getTweetService().update(tweet);
                    ApplicationContext.getInstance.getUserService()
                            .update(ApplicationContext.getInstance.getUser());
                    isLiked = true;
                    System.out.println("UNLIKED");
                    if (tweet.getLikedUsers().isEmpty()) break;
                }
            }
            if (!isLiked) {
                tweet.getLikedUsers().add(ApplicationContext.getInstance.getUser());
                ApplicationContext.getInstance.getUser().getLikedTweets().add(tweet);
                ApplicationContext.getInstance.getTweetService().update(tweet);
                ApplicationContext.getInstance.getUserService().update(ApplicationContext.getInstance.getUser());

                System.out.println("LIKED!!!");
            }
        } else System.out.println("there is no tweet with this id in system");

        return new InsideMenu();

    }
}
