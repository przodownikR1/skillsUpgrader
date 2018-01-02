package pl.java.scalatech.users.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import pl.java.scalatech.domains.AbstractEntity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends AbstractEntity{


	private static final long serialVersionUID = -1602864870067450805L;
	private String firstName,lastName,login,email;




}
