package pl.java.scalatech.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pl.java.scalatech.skills.repo.SkillRepo;
import pl.java.scalatech.tags.repo.TagRepo;
import pl.java.scalatech.tasks.repo.TaskRepo;
import pl.java.scalatech.users.repo.UserRepo;

@Configuration
@EnableJpaRepositories(basePackageClasses = { TaskRepo.class, UserRepo.class, TagRepo.class, SkillRepo.class })
public class JpaSourceConfig {


    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource primaryDataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }
}
