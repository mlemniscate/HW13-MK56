package ir.maktab.service.front.menu;


import ir.maktab.domain.User;
import ir.maktab.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class FirstMenu extends Menu implements RunnableMenu<Void> {

    public FirstMenu(ArrayList<String> items) {
        super(items);
    }

    @Override
    public Void runMenu(){
        while (true) {
            switch (getItemFromConsole()) {
                case 1:
                    User loginUser = ApplicationContext.getUserService().login();
                    if (!Objects.isNull(loginUser)) {
                        new UserMenu(
                                new ArrayList<>(Arrays.asList("My Tweets", "Show All Tweets", "Edit Info", "Delete Account")),
                                loginUser
                        ).runMenu();
                    } else {
                        System.out.println("Your password or username is wrong!");
                    }
                    break;
                case 2:
                    ApplicationContext.getUserService().signUp();
                    break;
                case 3:
                    if (new CheckMenu("Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
    }


}
