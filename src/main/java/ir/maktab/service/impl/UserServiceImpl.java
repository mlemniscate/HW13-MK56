package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseEntityServiceImpl;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;
import ir.maktab.service.UserService;

public class UserServiceImpl extends BaseEntityServiceImpl<User, Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
