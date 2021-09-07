package ir.maktab.service.front.menu;

import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;
import ir.maktab.service.front.input.InputInt;
import ir.maktab.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class AllTweetsMenu extends Menu implements RunnableMenu<Void>{
    private final User user;
    private final List<Tweet> allTweets;

    public AllTweetsMenu(User user, List<Tweet> allTweets) {
        super(new ArrayList<>(Arrays.asList("Like/Dislike A Tweet", "Your Comments For a Tweet", "Show Full Info of a Tweet", "Back")));
        this.user = user;
        this.allTweets = allTweets;
        showAllTweets();
    }

    @Override
    public Void runMenu() {
        while (true) {
            Tweet tweet;
            switch (getItemFromConsole()) {
                case 1:
                    tweet = allTweets.get(enterTweetNumber() - 1);
                    ApplicationContext.getLikeService().likeATweet(user, tweet);
                    break;
                case 2:
                    tweet = allTweets.get(enterTweetNumber() - 1);
                    new TweetCommentMenu(user, tweet).runMenu();
                    break;
                case 3:
                    tweet = allTweets.get(enterTweetNumber() - 1);
                    showFullTweet(tweet);
                    break;
                case 4:
                    return null;
            }
        }
    }

    private void showFullTweet(Tweet tweet) {
        System.out.println("----------------------------------------------------" +
                "\nTweet text: " + tweet.getText() +
                "\nTweet likes: " + tweet.getLikeNumber() +
                "\nTweet comments: " + tweet.getCommentNumber() +
                "\n"
        );
        tweet.getComments().forEach(System.out::println);
    }

    private int enterTweetNumber() {
        return new InputInt("Enter your tweet number: ", allTweets.size(), 1, null)
                .getIntInput();
    }

    private void showAllTweets() {
        if(!Objects.isNull(allTweets)) {
            IntStream.range(0, allTweets.size()).forEach(item -> {
                System.out.println("#" + (item + 1) + ": " + allTweets.get(item).toString());
            });
        }
    }
}
