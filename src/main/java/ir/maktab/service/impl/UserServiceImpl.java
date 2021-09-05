package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;
import ir.maktab.service.UserService;
import ir.maktab.service.front.input.InputString;
import ir.maktab.service.front.menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;

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
        save(user);
    }

    public void editLastName(User user) {
        user.setLastName(enterLastName());
        save(user);
    }

    public void editUsername(User user) {
        user.setUsername(enterUsername());
        save(user);
    }

    public void editPassword(User user) {
        user.setPassword(enterPassword());
        save(user);
    }

    public void editEmail(User user) {
        user.setEmail(enterEmail());
        save(user);
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

    @Override
    public void editAccount(User user) {
        int itemFromConsole = new Menu(new ArrayList<>(Arrays.asList(
                "Edit FirstName",
                "Edit LastName",
                "Edit Password",
                "Edit Username",
                "Edit Email"))).getItemFromConsole();
        switch (itemFromConsole) {
            case 1:
                editFirstName(user);
                break;
            case 2:
                editLastName(user);
                break;
            case 3:
                editPassword(user);
                break;
            case 4:
                editUsername(user);
                break;
            case 5:
                editEmail(user);
                break;
        }
    }
}
