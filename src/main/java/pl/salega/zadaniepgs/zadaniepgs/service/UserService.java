package pl.salega.zadaniepgs.zadaniepgs.service;

import pl.salega.zadaniepgs.zadaniepgs.domain.User;
import pl.salega.zadaniepgs.zadaniepgs.domain.security.UserRole;

import java.util.Set;

public interface UserService {


    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
}
