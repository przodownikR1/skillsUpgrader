package pl.java.scalatech.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
class WebConfig {

	@Autowired
	RequestMappingHandlerAdapter requestMappingHandlerAdapter;

	@PostConstruct
	void init() {
		List<HandlerMethodReturnValueHandler> springHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
		List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(springHandlers);
		handlers.add(0, observableReturnValueHandler());
		requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
	}

	@Bean
	HandlerMethodReturnValueHandler observableReturnValueHandler() {
		return new ObservableReturnValueHandler();
	}

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}