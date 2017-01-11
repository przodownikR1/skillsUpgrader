package pl.java.scalatech.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import pl.java.scalatech.exception.ResourceNotFoundException;
import pl.java.scalatech.tasks.domain.Task;
import pl.java.scalatech.tasks.repo.TaskRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepoTest {

    private static final String TESTING = "testing";

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TaskRepo repo;

    @Test
    public void shouldEntityManagerInject() {
        assertThat(entityManager).isNotNull();
    }

    @Test
    public void shouldFindTagsByName() {
        this.entityManager.persist(Task.builder().name(TESTING).build());
        Task task = repo.findByName(TESTING).orElseThrow(() -> new ResourceNotFoundException());
        assertThat(task.getName()).isEqualTo(TESTING);

    }

}
