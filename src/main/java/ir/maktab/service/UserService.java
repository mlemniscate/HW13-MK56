package ir.maktab.service;

import ir.maktab.base.service.BaseEntityService;
import ir.maktab.domain.User;

public interface UserService extends BaseEntityService<User, Long> {
    User login();

    void signUp();

    void editAccount(User user);
}
