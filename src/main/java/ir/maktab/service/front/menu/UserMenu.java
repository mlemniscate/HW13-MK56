package ir.maktab.service.front.menu;


import ir.maktab.domain.User;
import ir.maktab.util.ApplicationContext;

import java.util.List;

public class UserMenu extends Menu implements RunnableMenu<Void> {
    private final User user;

    public UserMenu(List<String> items, User user) {
        super(items);
        this.user = user;
        System.out.printf("%n%nWelcome to your page %s %s.%n%n", user.getFirstName(), user.getLastName());
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
                    ApplicationContext.getUserService().editAccount(user);
                    break;
                case 4:
                    if (new CheckMenu("Are you sure you want to delete you account?").runMenu()) {
                        ApplicationContext.getUserService().delete(user);
                        return null;
                    }
                    else break;
            }
        }
    }

}


