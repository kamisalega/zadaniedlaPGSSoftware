package pl.salega.zadaniepgs.zadaniepgs.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.salega.zadaniepgs.zadaniepgs.ZadaniepgsApplication;
import pl.salega.zadaniepgs.zadaniepgs.repository.RoleRepository;
import pl.salega.zadaniepgs.zadaniepgs.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZadaniepgsApplication.class)
public class RepositoriesIntegrationTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }


}
