package pl.java.scalatech.tasks.domain;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;
import pl.java.scalatech.domains.AbstractEntity;

@Entity
@Data
@Builder
public class Task extends AbstractEntity{

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration duration;
}
