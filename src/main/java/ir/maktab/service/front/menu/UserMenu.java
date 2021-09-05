//package ir.maktab.service.front.menu;
//
//
//import ir.maktab.domain.User;
//import ir.maktab.service.front.input.InputInt;
//import ir.maktab.service.front.input.InputString;
//import ir.maktab.util.ApplicationContext;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserMenu extends ir.maktab.todo.front.menus.Menu implements ir.maktab.todo.front.menus.RunnableMenu<Void> {
//    private final User user;
//    private Comparator<Activity> comparator;
//
//    public UserMenu(List<String> items, User user) {
//        super(items);
//        this.user = user;
//        System.out.printf("%n%nWelcome to your page %s %s.%n%n", user.getFirstName(), user.getLastName());
//        this.comparator = ActivityComparators.getCreatedDateComparator(ComparatorOrder.DESC);
//        showActivities();
//    }
//
//    @Override
//    public Void runMenu() {
//        while (true) {
//            switch (getItemFromUser()) {
//                case 1:
//                    Activity savedActivity = getActivityInformation();
//                    user.getActivities().add(ApplicationContext.getActivityService().save(savedActivity));
//                    showActivities();
//                    break;
//                case 2:
//                    Activity activity = changeStatusOfAnActivity();
//                    ApplicationContext.getActivityService().save(activity);
//                    showActivities();
//                    break;
//                case 3:
//                    comparator = chooseComparatorOrder();
//                    showActivities();
//                    break;
//                case 4:
//                    if (new ir.maktab.todo.front.menus.CheckMenu(new ArrayList<String>() {{
//                        add("Yes");
//                        add("No");
//                    }},
//                            "\nAre you sure you want to log out?").runMenu()) return null;
//                    else break;
//            }
//        }
//    }
//
//    private Comparator<Activity> chooseComparatorOrder() {
//        int chosenCompareBase = chooseCompareBase();
//        ComparatorOrder comparatorOrder = chooseOrderBase();
//        switch (chosenCompareBase) {
//            case 1:
//                return ActivityComparators.getNameComparator(comparatorOrder);
//            case 2:
//                return ActivityComparators.getCreatedDateComparator(comparatorOrder);
//            case 3:
//                return ActivityComparators.getLastUpdatedDateComparator(comparatorOrder);
//            case 4:
//                return ActivityComparators.getStatusComparator(comparatorOrder);
//        }
//        return null;
//    }
//
//    private ComparatorOrder chooseOrderBase() {
//        System.out.println("\n1.Ascending\n2.Descending\n");
//        int intInput = new InputInt("Choose your order base for your activities: ", 2, 1, null).getIntInput();
//        return intInput == 1 ? ComparatorOrder.ASC : ComparatorOrder.DESC;
//    }
//
//    private int chooseCompareBase() {
//        System.out.println("\n1.Name\n2.Created Date\n3.Last Updated Date\n4.Status\n");
//        return new InputInt("Choose your order base for your activities: ", 4, 1, null).getIntInput();
//    }
//
//    private Activity changeStatusOfAnActivity() {
//        Activity activity = chooseActivity();
//        System.out.println("\n1.Open\n2.In Progress\n3.Completed\n");
//        int chosenItem = new InputInt("Choose a status for your activity: ", 3, 1, null).getIntInput();
//        activity.setActivityStatus(
//                chosenItem == 1 ? ActivityStatus.OPEN
//                        : chosenItem == 2 ? ActivityStatus.IN_PROGRESS
//                        : ActivityStatus.COMPLETED);
//        activity.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
//        return activity;
//    }
//
//    private Activity chooseActivity() {
//        List<Activity> activities = showActivities();
//        int chosenItem = new InputInt("\nEnter your activity number: ",
//                user.getActivities().size(), 1, null).getIntInput() - 1;
//        return activities.get(chosenItem);
//    }
//
//    private Activity getActivityInformation() {
//        return new Activity(
//                enterName(),
//                enterDescription(),
//                new Timestamp(System.currentTimeMillis()),
//                new Timestamp(System.currentTimeMillis()),
//                ActivityStatus.OPEN
//        );
//    }
//
//    private String enterDescription() {
//        return new InputString("Enter your activity description: ").getStringInput();
//    }
//
//    private String enterName() {
//        return new InputString("Enter your activity name: ").getStringInput();
//    }
//
//    private List<Activity> showActivities() {
//        List<Activity> activities = new ArrayList<>(user.getActivities());
//        activities.sort(comparator);
//        int count = 0;
//        for (Activity activity : activities) {
//            System.out.printf("%n#%02d%n%s%n", ++count, activity.toString());
//        }
//        return activities;
//    }
//}
//
//
