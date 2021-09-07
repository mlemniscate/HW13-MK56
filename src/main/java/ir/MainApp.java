package ir;

import com.github.javafaker.Faker;
import ir.maktab.domain.Tweet;
import ir.maktab.domain.User;
import ir.maktab.service.front.menu.FirstMenu;
import ir.maktab.util.ApplicationContext;
import ir.maktab.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class MainApp {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
//        insertInfo();
        new FirstMenu().runMenu();
//        test(entityManager);
    }

    public static void test(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<Tweet> root = query.from(Tweet.class);
        query.multiselect(root.get("text"), root.get("createdTime"));
        List<Tuple> resultList = entityManager.createQuery(query).getResultList();
        resultList.forEach(item -> {
            System.out.println(item.get(0) + " " + item.get(1));
        });
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
