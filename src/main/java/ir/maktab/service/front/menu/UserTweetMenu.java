package ir.maktab.service.front.menu;


import ir.maktab.domain.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UserTweetMenu extends Menu implements RunnableMenu<Void> {
    private final User user;

    public UserTweetMenu(User user) {
        super(new ArrayList<>(Arrays.asList("Add Tweet", "Edit Tweet", "Remove Tweet", "Back")));
        this.user = user;
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

}


