package ir;

import ir.maktab.service.front.menu.FirstMenu;
import ir.maktab.util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        HibernateUtil.getEntityManagerFactory().createEntityManager();
        new FirstMenu().runMenu();
    }
}
