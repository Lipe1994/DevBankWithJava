/*
package lipe.dev.bank;


import lipe.dev.bank.entities.seeds.ClienteSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupEvent {

    @Autowired
    ClienteSeed clienteSeed;

    @EventListener
    public void handleEvents(ContextRefreshedEvent event) {
        clienteSeed.insertData();
    }
}
 */