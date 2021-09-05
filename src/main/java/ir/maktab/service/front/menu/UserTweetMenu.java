package ir.maktab.service.front.menu;


import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;
import ir.maktab.service.front.input.InputInt;
import ir.maktab.service.front.input.InputString;
import ir.maktab.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class UserTweetMenu extends Menu implements RunnableMenu<Void> {
    private final User user;

    public UserTweetMenu(User user) {
        super(new ArrayList<>(Arrays.asList("Add Tweet", "Edit Tweet", "Remove Tweet", "Back")));
        this.user = user;
        showTweets();
    }

    @Override
    public Void runMenu() {
        while (true) {
            switch (getItemFromConsole()) {
                case 1:
                    user.getTweets().add(createTweet());
                    ApplicationContext.getUserService().save(user);
                    showTweets();
                    break;
                case 2:
                    if(user.getTweets().size() != 0) {
                        int tweetIndex = enterTweetNumber() - 1;
                        String tweetText = enterTweetText();
                        user.getTweets().get(tweetIndex).setText(tweetText);
                        user.getTweets().get(tweetIndex).setLastUpdatedTime(new Date(System.currentTimeMillis()));
                        ApplicationContext.getUserService().save(user);
                    }
                    showTweets();
                    break;
                case 3:
                    if(user.getTweets().size() != 0) {
                        int tweetIndex = enterTweetNumber() - 1;
                        Tweet tweet = user.getTweets().get(tweetIndex);
                        user.getTweets().remove(tweet);
                        ApplicationContext.getUserService().save(user);
                        ApplicationContext.getTweetService().delete(tweet);
                    }
                    showTweets();
                    break;
                case 4:
                    return null;
            }
        }
    }

    private int enterTweetNumber() {
        return new InputInt("Enter your tweet number: ", user.getTweets().size(), 1, null)
                .getIntInput();
    }

    private Tweet createTweet() {
        return new Tweet(enterTweetText(), new Date(System.currentTimeMillis()));
    }

    private String enterTweetText() {
        return new InputString("Enter your tweet text \n",
                "Your tweet has to be greater then 8 and less then 280 characters!",
                "^.{8,280}$",
                null).getStringInput();
    }

    private void showTweets() {
        if (user.getTweets().size() != 0) user.getTweets().forEach(System.out::println);
    }

}


