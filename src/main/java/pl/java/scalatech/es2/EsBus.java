package pl.java.scalatech.es2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.eventbus.EventBus;

@Configuration
class EsBus {

    @Bean
    EventBus eventBus() {
        return new EventBus("eventSourcing");
    }

    @Bean
    SimpleTradeAuditor auditor(EventBus eventBus) {
        return new SimpleTradeAuditor(eventBus);
    }

    @Bean
    SimpleTradeExecutor tradeExecutor(EventBus eventBus) {
        return new SimpleTradeExecutor(eventBus);

    }
}
