package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;
import ir.maktab.service.UserService;
import ir.maktab.service.front.input.InputString;

public class UserServiceImpl extends BaseEntityServiceImpl<User, Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    private String enterUsername() {
        return new InputString("Enter your username: ",
                "Your username not valid(use 8 to 20 alphanumeric characters).\nNotice: Maybe this username taken by other authors.",
                "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$",
                getAllUserNames()).getStringInput();
    }

    private String enterLastName() {
        return new InputString("Enter your last name: ",
                "Your last name must be 2 to 20 alphabetic characters.",
                "^[a-zA-Z]{2,20}$", null).getStringInput();
    }

    private String enterFirstName() {
        return new InputString("Enter your first name: ",
                "Your first name must be 2 to 20 alphabetic characters.",
                "^[a-zA-Z]{2,20}$", null).getStringInput();
    }

    private String enterPassword() {
        return new InputString("Enter your password: ",
                "Your password must be minimum 8 characters, at least one letter and one number.",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", null).getStringInput();
    }

    private String enterEmail() {
        return new InputString("Enter your email: ",
                "Your email address is wrong!",
                "^[A-Za-z0-9+_.-]+@(.+)$", null).getStringInput();
    }

    public void editFirstName(User user) {
        user.setFirstName(enterFirstName());
    }

    public void editLastName(User user) {
        user.setLastName(enterLastName());
    }

    public void editUsername(User user) {
        user.setUsername(enterUsername());
    }

    public void editPassword(User user) {
        user.setPassword(enterPassword());
    }

    private String[] getAllUserNames() {
        return repository.findAllUsernames().toArray(new String[0]);
    }

    @Override
    public User login() {
        String username = new InputString("Enter your username: ").getStringInput();
        String password = new InputString("Enter your password: ").getStringInput();
        return repository.findByUsernamePassword(username, password);
    }

    @Override
    public void signUp() {
        save(new User(
                enterFirstName(),
                enterLastName(),
                enterUsername(),
                enterPassword(),
                enterEmail()
        ));
    }
}
