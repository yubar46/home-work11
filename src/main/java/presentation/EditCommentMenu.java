package presentation;

import context.ApplicationContext;
import domain.Comment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EditCommentMenu implements Menu {
    Scanner console = new Scanner(System.in);
    Scanner console1 = new Scanner(System.in);

    @Override
    public Menu action() {

        System.out.println("enter your comment ID");
        Long id;
        try {
             id = console.nextLong();
        }catch (InputMismatchException exception){
            System.out.println("enter correct number");
            return new EditCommentMenu();


        }
        if (ApplicationContext.getInstance.getCommentService()
                .findByUserOwnerAndCommentId(ApplicationContext.
                        getInstance.getUser(), id) == null) {
            System.out.println("you have not any comment with this id");
            return new CommentMenu();
        } else {
            System.out.printf("%s %n %s %n %s %n", "1-delete comment", "2-edit comment", "3-return to comment menu");
            int choice = console.nextInt();
            switch (choice) {
                case 1:
                    if (ApplicationContext.getInstance.getCommentService().read(id) != null) {
                        ApplicationContext.getInstance.getCommentService().delete(id);
                        ApplicationContext.getInstance.setTweets(ApplicationContext.getInstance.getTweetService().showAllTweets());
                        ApplicationContext.getInstance.setUser(ApplicationContext.getInstance.getUserService().read(ApplicationContext.getInstance.getUser().getId()));
                    } else System.out.println("comment id is wrong");
                    break;
                case 2:
                    if (ApplicationContext.getInstance.getCommentService().read(id) != null) {
                        Comment comment = ApplicationContext.getInstance.getCommentService().read(id);
                        System.out.println("write a new comment");
                        String newComment = console1.nextLine();
                        comment.setComment(newComment);
                        ApplicationContext.getInstance.getCommentService().update(comment);
                        ApplicationContext.getInstance.setTweets(ApplicationContext.getInstance.getTweetService().showAllTweets());
                        ApplicationContext.getInstance.setUser(ApplicationContext.getInstance.getUserService().read(ApplicationContext.getInstance.getUser().getId()));


                    }
                case 3:
                    return new CommentMenu();
            }


            return new InsideMenu();
        }


    }
}
