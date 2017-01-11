package pl.java.scalatech.skills.domain;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;
import pl.java.scalatech.domains.AbstractEntity;

@Entity
@Data
@Builder
public class Skill extends AbstractEntity{
    /**
     * 
     */
    private static final long serialVersionUID = -4645686018545890145L;
    private String name;
    private String shortName;

}
