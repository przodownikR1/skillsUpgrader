package pl.java.scalatech.config;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.java.scalatech.users.domain.User;
import pl.java.scalatech.users.repo.UserCommandRepo;
@Configuration
class PopulationConfig {

	@Autowired
	private UserCommandRepo userCommand;

	// @formatter:off
	@Bean
	CommandLineRunner populate(){
		return args -> IntStream.range(0, 10)
				.forEach(value -> userCommand.save(
						User.builder().email("przodownik"+value+"@pl.pl").firstName("fn_"+value).lastName("ln_"+value).login("login_"+value).build())
						);
	}

	// @formatter:on
}
