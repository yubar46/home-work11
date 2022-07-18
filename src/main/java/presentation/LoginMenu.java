package presentation;

import context.ApplicationContext;

import java.util.Scanner;

public class LoginMenu implements Menu {
    @Override
    public Menu action() {

        Scanner console = new Scanner(System.in);
        boolean checkLogin =false;
        do {
            System.out.println("enter your userName");
            String username = console.next();
            System.out.println("enter your password");
            String password= console.next();

            if (ApplicationContext.getInstance.getUserRepository().findByUserName(username)
                    !=null)ApplicationContext.getInstance.setUser(ApplicationContext.getInstance
                    .getUserRepository().findByUserName(username));
            if (ApplicationContext.getInstance.getUser().getPassword().equals(password))checkLogin=true;
            else System.out.println("wrong username or password entered");

        }while (!checkLogin);

        return null;
    }
}
