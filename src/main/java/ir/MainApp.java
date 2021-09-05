package ir;

import ir.maktab.service.front.menu.FirstMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        new FirstMenu(new ArrayList<>(Arrays.asList("Sign Up", "Login", "Exit"))).runMenu();
    }
}
