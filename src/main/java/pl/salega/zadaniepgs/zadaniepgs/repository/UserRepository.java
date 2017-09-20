package pl.salega.zadaniepgs.zadaniepgs.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.zadaniepgs.zadaniepgs.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
