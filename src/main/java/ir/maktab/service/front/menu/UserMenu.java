package ir.maktab.service.front.menu;


import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;
import ir.maktab.service.front.input.InputString;
import ir.maktab.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserMenu extends Menu implements RunnableMenu<Void> {
    private final User user;

    public UserMenu(User user) {
        super(new ArrayList<>(Arrays.asList("My Tweets", "Show All Tweets", "Edit Info", "Delete Account","Search a User with Username", "Log Out")));
        this.user = user;
        System.out.printf("%n%nWelcome to your page %s %s.%n%n", user.getFirstName(), user.getLastName());
    }

    @Override
    public Void runMenu() {
        while (true) {
            switch (getItemFromConsole()) {
                case 1:
                    new UserTweetMenu(user).runMenu();
                    break;
                case 2:
                    List<Tweet> all = ApplicationContext.getTweetService().findAll();
                    new AllTweetsMenu(user, all).runMenu();
                    break;
                case 3:
                    ApplicationContext.getUserService().editAccount(user);
                    break;
                case 4:
                    if (new CheckMenu("Are you sure you want to delete you account?").runMenu()) {
                        ApplicationContext.getUserService().delete(user);
                        return null;
                    }
                    else break;
                case 5:
                    String username = new InputString("Enter a username: ").getStringInput();
                    User userByUsername = ApplicationContext.getUserService().getUserByUsername(username);
                    if(Objects.isNull(userByUsername)) {
                        System.out.println("There is no user with this username!!");;
                    } else {
                        System.out.println(userByUsername);
                    }
                    break;
                case 6:
                    if(new CheckMenu("Are you sure you want to log out?").runMenu()) return null;
                    else break;
            }
        }
    }

}


