package pl.java.scalatech.user.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import pl.java.scalatech.users.domain.User;
import pl.java.scalatech.users.exception.UserNotFoundException;
import pl.java.scalatech.users.repo.UserRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    private static final String SLAWEK = "slawek";

    private static final String PRZODOWNIK = "przodownik";

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepo repo;

    @Test
    public void shouldEntityManagerInject(){
        assertThat(entityManager).isNotNull();
    }

    @Test
    public void shouldFindUserByLogin() {
        this.entityManager.persist(User.builder().name(SLAWEK).login(PRZODOWNIK).email("przodownikR1@gmail.com").build());
        User user = repo.findByLogin(PRZODOWNIK).orElseThrow(()-> new UserNotFoundException());
        assertThat(user.getName()).isEqualTo(SLAWEK);
       
    }


}