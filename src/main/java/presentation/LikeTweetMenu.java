package presentation;

import context.ApplicationContext;
import domain.Tweet;
import domain.User;

import java.util.Scanner;

public class LikeTweetMenu implements Menu {
    Scanner console = new Scanner(System.in);
    @Override
    public Menu action() {
        System.out.println("enter your tweet ID");
        long select = console.nextInt();
        Tweet tweet;
        boolean isLiked =false;
        if (ApplicationContext.getInstance.getTweetService().read(select)!= null){
            tweet= ApplicationContext.getInstance.getTweetService().read(select);
            for (User user: tweet.getLikedUsers()) {
                if (user.getUserName().equals(ApplicationContext.getInstance.getUser().getUserName())){
                    tweet.getLikedUsers().remove(ApplicationContext.getInstance.getUser());
                    isLiked= true;
                    System.out.println("UNLIKED");
                }
            }
            if (!isLiked){
                tweet.getLikedUsers().add(ApplicationContext.getInstance.getUser());
                System.out.println("LIKED!!!");
            }
        }else System.out.println("there is no tweet with this id in system");

        return  new InsideMenu();

    }
}
