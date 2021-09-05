package ir.maktab.service.front.menu;

import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            switch (getItemFromConsole()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return null;
            }
        }
    }

    private void showAllTweets() {
        IntStream.range(0, allTweets.size()).forEach(item -> {
            System.out.println("#"+ (item + 1) + ": " + allTweets.get(item).toString());
        });
    }
}
