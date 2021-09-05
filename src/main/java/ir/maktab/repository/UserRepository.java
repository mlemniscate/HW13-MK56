package ir.maktab.repository;

import ir.maktab.base.repository.BaseEntityRepository;
import ir.maktab.domain.User;

import java.util.List;

public interface UserRepository extends BaseEntityRepository<User, Long> {

    List<String> findAllUsernames();

    User findByUsernamePassword(String username, String password);
}
