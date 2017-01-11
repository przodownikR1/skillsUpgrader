package pl.java.scalatech.skills.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.skills.domain.Skill;

public interface SkillRepo extends JpaRepository<Skill, Long> {

}
