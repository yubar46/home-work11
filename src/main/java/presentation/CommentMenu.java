package presentation;

import java.util.Scanner;

public class CommentMenu implements Menu {
    Scanner console = new Scanner(System.in);
    @Override
    public Menu action() {
        int choice;
        boolean check =false;
        do {
            System.out.printf("%s %n %s %n %s","1-new comment","edit comment","3- back to main menu");
            choice = console.nextInt();
            if (choice==1||choice==2||choice==3)check=true;
            switch (choice){
                case 1: return new NewCommentMenu();
                case 2: return new EditCommentMenu();
                case 3: return new InsideMenu();
            }

        }while (!check);

        return null;

    }
}