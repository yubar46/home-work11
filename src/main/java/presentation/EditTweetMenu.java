package presentation;

import context.ApplicationContext;
import domain.Comment;
import domain.Tweet;
import domain.User;

import java.util.InputMismatchException;
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
            Long id;
              try {
                id = console.nextLong();
            }catch (InputMismatchException exception){
                System.out.println("enter correct number");
                return new EditTweetMenu();


            }
            if (id == -1) return new InsideMenu();

            List<Tweet> tweets = ApplicationContext.getInstance
                    .getTweetService().findUserTweets(ApplicationContext.getInstance.getUser());
            if (tweets.isEmpty()) System.out.println("you have not any tweet yet");
            else
                for (Tweet tweet : tweets) {
                    if (tweet.getId().equals(id)) {
                        myTweet = tweet;
                        check = true;
                        System.out.printf("%s %n %s %n ", "1-rewrite the tweet", "2- delete tweet ");
                        int choice ;

                        try {
                            choice = console.nextInt();
                        }catch (InputMismatchException exception){
                            System.out.println("enter correct number");
                            return new EditTweetMenu();


                        }                        switch (choice) {
                            case 1:
                                tweet.setTweet(editTweet());
                                ApplicationContext.getInstance.getTweetService().update(tweet);
                                ApplicationContext.getInstance.setTweets(ApplicationContext.getInstance.getTweetService().showAllTweets());
                                break;
                            case 2:

                                tweet.getLikedUsers().removeAll(tweet.getLikedUsers());
                                for (Comment comment:tweet.getComments()) {
                                  ApplicationContext.getInstance.getCommentService().delete(comment.getId());
                                }
                                ApplicationContext.getInstance.getTweetService().update(tweet);

                                ApplicationContext.getInstance.getTweetService().delete(tweet.getId());
                                tweets.remove(tweet);
                                break;
                        }

                    }

                    if (tweets.isEmpty()) break;

                }
            if (!check) System.out.println("you have not any tweet with this id try again or for exit enter -1");

        } while (!check);


        return new InsideMenu();

    }

    public String editTweet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("write a new tweet");
        String edited = scanner.nextLine();
        return edited;
    }
}
