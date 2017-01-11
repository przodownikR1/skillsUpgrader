package pl.java.scalatech.tags.domain;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;
import pl.java.scalatech.domains.AbstractEntity;

@Entity
@Data
@Builder
public class Tag extends AbstractEntity {

    private static final long serialVersionUID = -6746681977658541460L;
    private String name;

}
