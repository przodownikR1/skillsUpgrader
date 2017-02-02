package pl.java.scalatech.users.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.java.scalatech.es.PublishEvent;

@Configuration
class ESUserConfiguration {

	@Bean
	PublishEvent producer(ApplicationEventPublisher publisher){
		return new PublishEvent(publisher);
	}

	@Bean
	ReceiverUser receiver(){
		return new ReceiverUser();
	}

}