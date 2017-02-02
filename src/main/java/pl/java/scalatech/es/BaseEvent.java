package pl.java.scalatech.es;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.Data;
import pl.java.scalatech.domains.AbstractEntity;
import pl.java.scalatech.users.domain.User;

@Data
@MappedSuperclass
public class BaseEvent<Entity extends AbstractEntity> implements EventOperation {

	private String id;

	private EventType type;

	private String entity;

	@Transient
	private Entity entityObj;

	private String entityId;

	private LocalDateTime createdDate = LocalDateTime.now();

	private String txId;

	private String userId;

	private String body;

	@Override
	public <E extends BaseEvent<? extends AbstractEntity>> E createEvent(E event, EventType type,Optional<User> user) {
		event.setBody(this.serializedPayload(event));
		event.setEntity(entityObj.getClassName());
		event.setType(type);
		event.setEntityId(entityObj.getId().toString());
		event.setUserId(user.orElseGet(User::new).getId().toString());
		return event;
	}


}