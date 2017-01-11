package pl.java.scalatech.tag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import pl.java.scalatech.exception.ResourceNotFoundException;
import pl.java.scalatech.tags.domain.Tag;
import pl.java.scalatech.tags.repo.TagRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TagRepoTest {

    private static final String JAVA = "JAVA";

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TagRepo repo;

    @Test
    public void shouldEntityManagerInject() {
        assertThat(entityManager).isNotNull();
    }

    @Test
    public void shouldFindTagByName()
    {
        this.entityManager.persist(Tag.builder().name(JAVA).build());
        Tag tag = repo.findByName(JAVA).orElseThrow(() -> new ResourceNotFoundException());
        assertThat(tag.getName()).isEqualTo(JAVA);

    }

}
