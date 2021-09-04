package ir;

import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;

public class MainApp {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    }
}
