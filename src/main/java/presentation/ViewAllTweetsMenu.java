package presentation;

import context.ApplicationContext;
import domain.Tweet;

import java.applet.AppletContext;
import java.util.List;

public class ViewAllTweetsMenu implements Menu {
    @Override
    public Menu action() {
        List<Tweet> tweets;
        if (ApplicationContext.getInstance.getTweetService().showAllTweets() != null) {
            tweets = ApplicationContext.getInstance.getTweetService().showAllTweets();
            ApplicationContext.getInstance.setTweets(tweets);
            for (int i = 0; i < tweets.size(); i++) {
                System.out.println(tweets.get(i));
                tweets.get(i).getComments().forEach(System.out::println);
            }

        }
        return new InsideMenu();
    }
}
