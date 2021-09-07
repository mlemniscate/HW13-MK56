package ir.maktab.service.front.menu;

import ir.maktab.domain.Comment;
import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;
import ir.maktab.service.front.input.InputInt;
import ir.maktab.service.front.input.InputString;
import ir.maktab.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.stream.IntStream;

public class TweetCommentMenu extends Menu implements RunnableMenu<Void>{
    private final User user;
    private final Tweet tweet;

    public TweetCommentMenu(User user, Tweet tweet) {
        super(new ArrayList<>(Arrays.asList("Add Comment", "Edit Comment", "Delete Comment", "Back")));
        this.user = user;
        this.tweet = tweet;
        showAllUserComments();
    }

    @Override
    public Void runMenu() {
        while (true) {
            int commentIndex = 0;
            switch (getItemFromConsole()) {
                case 1:
                    Comment comment = new Comment(enterCommentText(), new Date(System.currentTimeMillis()), user.getId());
                    tweet.getComments().add(comment);
                    showAllUserComments();
                    break;
                case 2:
                    commentIndex = enterCommentNumber() - 1;
                    if(tweet.getComments().get(commentIndex).getUserId().equals(user.getId())) {
                        tweet.getComments().get(commentIndex).setText(enterCommentText());
                        tweet.getComments().get(commentIndex).setLastUpdatedTime(new Date(System.currentTimeMillis()));
                        showAllUserComments();
                    } else {
                        System.out.println("This comment isn't your comment!!\nYou cannot edit.");
                    }
                    break;
                case 3:
                    if(tweet.getComments().get(commentIndex).getUserId().equals(user.getId())) {
                        commentIndex = enterCommentNumber() - 1;
                        tweet.getComments().remove(commentIndex);
                        showAllUserComments();
                    } else {
                        System.out.println("This comment isn't your comment!!\nYou cannot delete.");
                    }
                    break;
                case 4:
                    ApplicationContext.getTweetService().save(tweet);
                    return null;
            }
        }
    }

    private String enterCommentText() {
        return new InputString("Enter your comment text \n",
                "Your comment has to be greater then 8 and less then 255 characters!",
                "^.{8,255}$",
                null).getStringInput();
    }

    private int enterCommentNumber() {
        return new InputInt("Enter your tweet number: ", tweet.getCommentNumber(), 1, null)
                .getIntInput();
    }

    private void showAllUserComments() {
        System.out.println("\nYour comments for this tweet.");
        if(!Objects.isNull(tweet.getComments())) {
            IntStream.range(0, tweet.getComments().size()).forEach(item -> {
                    System.out.println("#" + (item + 1) + ": " + tweet.getComments().get(item).toString());
            });
        }
    }
}
