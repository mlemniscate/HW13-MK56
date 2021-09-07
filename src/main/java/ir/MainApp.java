package ir;

import com.github.javafaker.Faker;
import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;
import ir.maktab.service.front.menu.FirstMenu;
import ir.maktab.util.ApplicationContext;
import ir.maktab.util.HibernateUtil;

import java.util.Date;
import java.util.stream.IntStream;

public class MainApp {
    public static void main(String[] args) {
        HibernateUtil.getEntityManagerFactory().createEntityManager();
//        insertInfo();
        new FirstMenu().runMenu();
    }

    private static void insertInfo() {
        Faker faker = new Faker();
        User user1 = new User("Milad", "Abdi", "abdimilad", "123456", "milad@gmail.com");
        User user2 = new User("Behzad", "Ganbari", "ganbaribehzad", "123456", "behzad@gmail.com");
        IntStream.range(1, 51).forEach(item -> {
            user1.getTweets().add(new Tweet(faker.lorem().characters(20, 279), new Date(System.currentTimeMillis())));
            user2.getTweets().add(new Tweet(faker.lorem().characters(20, 279), new Date(System.currentTimeMillis())));
            ApplicationContext.getUserService().save(user1);
            ApplicationContext.getUserService().save(user2);
        });
    }


}
