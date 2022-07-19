package presentation;

import context.ApplicationContext;

import java.util.Scanner;

public class EditProfileMenu implements Menu {
    Scanner console = new Scanner(System.in);

    @Override
    public Menu action() {
        System.out.printf("%s%n%s%n%s%n%s%n%s%n", "1- change password", "2- change first name",
                "3- change second name", "4- delete account", "5- back to main menu");
        int choice = console.nextInt();

        switch (choice) {
            case 1:
                changePassword();
                break;
            case 2:
                changeFirstName();
                break;
            case 3:
                changeSecondName();
                break;
            case 4:
                deleteAccount();
                break;
            case 5:
                return new InsideMenu();

        }

        return new EditProfileMenu();
    }

    private void changeFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your first name");
        String firstName = scanner.nextLine();
        ApplicationContext.getInstance.getUser().setFirstName(firstName);
        ApplicationContext.getInstance.getUserService().update(ApplicationContext.getInstance.getUser());
        System.out.println("first name changed");
    }

    private void changeSecondName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your second name");
        String secondName = scanner.nextLine();
        ApplicationContext.getInstance.getUser().setLastName(secondName);
        ApplicationContext.getInstance.getUserService().update(ApplicationContext.getInstance.getUser());
        System.out.println("second name changed");
    }

    private void changePassword() {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        String password;
        do {
            System.out.println("enter your new password");
            password = scanner.nextLine();
            System.out.println("enter your new password again");
            String password2 = scanner.nextLine();
            if (!password.equals(password2)) {
                System.out.println("its dose not match try again");
            } else check = true;
        } while (!check);

        ApplicationContext.getInstance.getUser().setPassword(password);
        ApplicationContext.getInstance.getUserService().update(ApplicationContext.getInstance.getUser());
        System.out.println("password name changed");

    }

    private Menu deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("for delete account enter -1-");
        System.out.println("for back to account menu  enter -2-");
        int choice = console.nextInt();
        switch (choice) {
            case 1: {
                ApplicationContext.getInstance.getUserService().
                        delete(ApplicationContext.getInstance.getUser().getId());
                ApplicationContext.getInstance.setUser(null);
                return new FirstMenu();
            }
            case 2:
                return new EditProfileMenu();
        }
        return new EditProfileMenu();
    }


}
