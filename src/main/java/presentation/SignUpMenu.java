package presentation;

import context.ApplicationContext;
import domain.User;
import javafx.scene.transform.Scale;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Scanner;

public class SignUpMenu implements  Menu {
    Scanner console = new Scanner(System.in);
    @Override
    public Menu action() {

        System.out.println("please enter your first name");
        String firstName = console.nextLine();
        System.out.println("please enter your first last name");
        String lastName = console.next();
        String username;
        do {
            System.out.println("please enter your first username");
            username= console.next();
        }while (!checkUserName(username));
        String password;
        boolean check= false;
        do {
            System.out.println("please enter your first password");
            password = console.next();

            if (password.length()<8) System.out.println("your password must be greater than 8 characters");
                else check=checkPassword(password);
        }while (!check);
        User user = new  User(username,password,firstName,lastName);
        ApplicationContext.getInstance.setUser(user);
        ApplicationContext.getInstance.getUserService().create(user);
        return new InsideMenu();
    }

    private boolean checkUserName(String username){
        boolean check = false;
        if (ApplicationContext.getInstance.getUserRepository().findByUserName(username)!=null)
            System.out.println("this username is already taken please enter choose another username");
        else check=true;
        return true;

    }

    private boolean checkPassword(String password){

        boolean check =false;
        System.out.println("please enter your password again");
        String checkPassword = console.next();
        if (password.equals(checkPassword))check=true;
        else System.out.println("first password and second password is not same enter password again");
        return check;


    }
}
