/**
 * Created by bernd on 21.02.2017.
 */

import com.google.common.eventbus.*;

public class BatteryMediator extends Subscriber {
    private String identifier;

    public BatteryMediator(String identifier) {
        // TODO Portverbindung zu den Komponenten
        this.identifier = identifier;
    }

    @Subscribe
    public void receive(OnEvent event) {

    }

    @Subscribe
    public void receive(OffEvent event) {

    }

    @Subscribe
    public void receive(ChargeEvent event) {

    }

    @Subscribe
    public void receive(EjectEvent event) {

    }
}
