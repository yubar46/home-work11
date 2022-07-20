package presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommentMenu implements Menu {
    Scanner console = new Scanner(System.in);

    @Override
    public Menu action() {
        int choice;
        boolean check = false;
        do {
            System.out.printf("%s%n%s%n%s%n", "1-new comment", "2-edit comment", "3- back to main menu");
            try {
                choice = console.nextInt();
            }catch (InputMismatchException exception){
                System.out.println("enter correct number");
                return new FirstMenu();


            }
            if (choice == 1 || choice == 2 || choice == 3) check = true;
            switch (choice) {
                case 1:
                    return new NewCommentMenu();
                case 2:
                    return new EditCommentMenu();
                case 3:
                    return new InsideMenu();
            }

        } while (!check);

        return new CommentMenu();

    }
}
