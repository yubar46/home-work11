package presentation;

import context.ApplicationContext;
import domain.Tweet;

import java.util.List;
import java.util.Scanner;

public class EditTweetMenu implements Menu {
    Scanner console = new Scanner(System.in);
    @Override
    public Menu action() {

        Tweet myTweet;
        boolean check = false;
        do {
            System.out.println("enter your tweet ID");
            Long id = console.nextLong();
            if (id == -1) return new InsideMenu();

            List<Tweet> tweets = ApplicationContext.getInstance.getUser().getTweets();
            for (Tweet tweet : tweets) {
                if (tweet.getId() == id) {
                    myTweet = tweet;
                    check = true;
                    System.out.printf("%s %n %s %n ","1-rewrite the tweet","2- delete tweet ");
                    int choice = console.nextInt();
                    switch (choice){
                        case 1: tweet.setTweet(editTweet());
                        ApplicationContext.getInstance.getTweetService().update(tweet);
                        ApplicationContext.getInstance.setTweets(ApplicationContext.getInstance.getTweetService().showAllTweets());

                        case 2: ApplicationContext.getInstance.getTweets().remove(tweet);
                        ApplicationContext.getInstance.getTweetService().delete(tweet.getId());
                        tweets.remove(tweet);
                    }

                }


            }
            if (!check) System.out.println("you have not any tweet with this id try again or for exit enter -1");

        } while (!check);


        return new InsideMenu();

    }

    public String editTweet(){
        System.out.println("write a new tweet");
        return console.nextLine();

    }
}
