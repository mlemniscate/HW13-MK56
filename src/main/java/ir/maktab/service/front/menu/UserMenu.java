package ir.maktab.service.front.menu;


import ir.maktab.domain.User;
import ir.maktab.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

public class UserMenu extends Menu implements RunnableMenu<Void> {
    private final User user;

    public UserMenu(User user) {
        super(new ArrayList<>(Arrays.asList("My Tweets", "Show All Tweets", "Edit Info", "Delete Account", "Log Out")));
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
                    if(new CheckMenu("Are you sure you want to log out?").runMenu()) return null;
                    else break;
            }
        }
    }

}


