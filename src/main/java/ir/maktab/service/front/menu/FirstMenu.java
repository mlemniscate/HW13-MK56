package ir.maktab.service.front.menu;


import ir.maktab.util.ApplicationContext;

import java.util.ArrayList;

public class FirstMenu extends Menu implements RunnableMenu<Void> {

    public FirstMenu(ArrayList<String> items) {
        super(items);
    }

    // This method do all the first menu tasks
    @Override
    public Void runMenu(){
        while (true) {
            switch (getItemFromUser()) {
                case 1:
//                    User loginUser = ApplicationContext.getUserService().login();
//                    if (!Objects.isNull(loginUser)) {
//                        new UserMenu(
//                                new ArrayList<String>() {{
//                                    add("Add Activity");
//                                    add("Change Activity Status");
//                                    add("Sort Activities");
//                                    add("Log Out");
//                                }},
//                                loginUser
//                        ).runMenu();
//                    } else {
//                        System.out.println("Your password or username is wrong!");
//                    }
                    break;
                case 2:
                    ApplicationContext.getUserService().signUp();
                    break;
                case 3:
                    if (new CheckMenu(new ArrayList<String>() {{
                        add("Yes");
                        add("No");
                    }},
                            "Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
    }


}
