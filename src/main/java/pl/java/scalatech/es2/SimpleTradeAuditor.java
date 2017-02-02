package pl.java.scalatech.es2;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class SimpleTradeAuditor {
    private List<TradeEvent> tradeEvents = Lists.newArrayList();

    public SimpleTradeAuditor(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void auditTrade(TradeEvent tradeAccountEvent) {
        tradeEvents.add(tradeAccountEvent);
        System.out.println("Received trade " + tradeAccountEvent);
    }
}