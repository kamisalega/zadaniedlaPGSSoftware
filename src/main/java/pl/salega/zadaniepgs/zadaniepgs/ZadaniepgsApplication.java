package pl.salega.zadaniepgs.zadaniepgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.salega.zadaniepgs.zadaniepgs.domain.User;
import pl.salega.zadaniepgs.zadaniepgs.domain.security.Role;
import pl.salega.zadaniepgs.zadaniepgs.domain.security.UserRole;
import pl.salega.zadaniepgs.zadaniepgs.service.UserService;
import pl.salega.zadaniepgs.zadaniepgs.utilty.SecurityUtility;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ZadaniepgsApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(ZadaniepgsApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        User user1 = new User();
        user1.setUsername("kamilsalega");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("kamilsalega"));
        user1.setEmail("admin@hotmail.com");


        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(0);
        role1.setName("ROLE_ADMIN");

        userRoles.add(new UserRole(user1, role1));
        userService.createUser(user1, userRoles);
    }
}
