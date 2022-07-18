package presentation;

import java.util.Scanner;

public class FirstMenu implements Menu {

    @Override
    public Menu action() {
        int choice;
        boolean trueChoice=false;
        do {
            System.out.printf("%s %n %s %n %s","1- sign up","2- login","3-exit");
            Scanner console = new Scanner(System.in);
            choice = console.nextInt();
            if (choice==1||choice==2||choice==3)trueChoice=true;
            else System.out.println("wrong number entered");
        }while (!trueChoice);

        switch (choice){
            case 1:return new LoginMenu();
            case 2:return new SignUpMenu();
            case 3:System.exit(0);
        }
        return null;
    }
}
