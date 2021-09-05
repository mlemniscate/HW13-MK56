package ir.maktab.service.front.menu;

import java.util.ArrayList;

public class CheckMenu extends Menu implements RunnableMenu<Boolean>{
    private final String message;
    private boolean isAccepted;

    public CheckMenu(ArrayList<String> items, String message) {
        super(items);
        this.message = message;
    }

    @Override
    public Boolean runMenu() {
        System.out.println("\n" + message);
        while(true) {
            switch (getItemFromUser()) {
                case 1:
                    return true;
                case 2:
                    return false;
            }
        }
    }
}
