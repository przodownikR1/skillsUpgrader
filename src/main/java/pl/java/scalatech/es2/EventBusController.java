package pl.java.scalatech.es2;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
public class EventBusController {

    private final SimpleTradeExecutor ste;

    public EventBusController(SimpleTradeExecutor simpleTradeExecutor) {
        this.ste = simpleTradeExecutor;
    }

    @GetMapping("/")
    HttpEntity<Void> post() {
        ste.executeTrade();
        return ResponseEntity.noContent().build();

    }
}
