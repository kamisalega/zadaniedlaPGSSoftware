package pl.salega.zadaniepgs.zadaniepgs.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.zadaniepgs.zadaniepgs.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByname(String name);
}
