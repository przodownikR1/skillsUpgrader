package pl.java.scalatech.es;

import lombok.Getter;
import lombok.ToString;
import pl.java.scalatech.users.domain.User;

@ToString
public class UserModifiedEvent {

	@Getter
	private final User user;
	@Getter
	private final boolean importantChange;

	public UserModifiedEvent(User user) {
		this(user, false);
	}

	public UserModifiedEvent(User user, boolean importantChange) {

		this.user = user;
		this.importantChange = importantChange;
	}

}