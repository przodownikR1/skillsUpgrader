package pl.java.scalatech.guava;

import org.junit.Test;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusTest {

 
        private  EventBus eb = new EventBus("eb");

        @Test
        public void shouldEventBusWork() {
            eb.register(new Sub1());
            eb.register(new Sub2());
            for (int i = 0; i < 10; i++) {
                eb.post(i);
                eb.post("s" + i);
            }

        }
    }

     class Sub1 {
        @Subscribe
        public void sub(String s) throws InterruptedException {
            System.out.println("sub1->" + s);
            Thread.sleep(500);
        }
    }

     class Sub2 {
        @Subscribe
        @AllowConcurrentEvents
        public void sub(Integer i) {
            System.out.println("sub2->" + i);
        }
    }

