package pl.java.scalatech.es2;

import java.util.Date;
import java.util.Random;

import com.google.common.eventbus.EventBus;

public class SimpleTradeExecutor {
    private final EventBus eventBus;

    public SimpleTradeExecutor(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void executeTrade() {
        TradeEvent tradeAccountEvent = processTrade();
        eventBus.post(tradeAccountEvent);
    }

    private TradeEvent processTrade() {
        Random r = new Random();
        Date executionTime = new Date();

        TradeEvent tradeAccountEvent = new TradeEvent(r.nextDouble(), executionTime);

        return tradeAccountEvent;
    }
}