package presentation;

import java.util.Scanner;

public class InsideMenu implements Menu {
    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        int choice;
        boolean check = false;
        do {
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n", "1- view all tweets", "2- write a tweet",
                    "3- edit my tweets", "4- like or dislike a tweet", "5- comment on tweets", "6- edit profile");
            choice = console.nextInt();
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6) check = true;
        } while (!check);

        switch (choice) {
            case 1:
                return new ViewAllTweetsMenu();
            case 2:
                return new WriteTweetMenu();
            case 3:
                return new EditTweetMenu();
            case 4:
                return new LikeTweetMenu();
            case 5:
                return new CommentMenu();
            case 6:
                return new EditProfileMenu();
        }

        return null;

    }
}
