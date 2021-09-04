package ir.maktab.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("HW13");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }
}
