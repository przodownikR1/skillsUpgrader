package pl.java.scalatech.es;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ESConfiguration {

	@Bean
	PublishEvent producer(ApplicationEventPublisher publisher){
		return new PublishEvent(publisher);
	}

	@Bean
	Receiver receiver(){
		return new pl.java.scalatech.es.Receiver();
	}

}
