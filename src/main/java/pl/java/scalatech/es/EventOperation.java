package pl.java.scalatech.es;

import java.util.Optional;

import com.google.gson.Gson;

import pl.java.scalatech.domains.AbstractEntity;
import pl.java.scalatech.users.domain.User;

@FunctionalInterface
public interface EventOperation {

	Gson gson = new Gson();

<E extends BaseEvent<? extends AbstractEntity>> E createEvent(E event,EventType type,Optional<User> user);


default <E extends BaseEvent<? extends AbstractEntity>> String serializedPayload(E event){
	return gson.toJson(event);
}

}