package pl.java.scalatech.domains;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractEntity implements Serializable {     
    
    private static final long serialVersionUID = -8849524213300144330L;
    @Id @GeneratedValue
    protected Long id;
}
