import com.google.common.eventbus.EventBus;
/**
 * Created by bernd on 21.02.2017.
 */
public class BatteryCharger {

    private String name, type;
    private EventBus eventBus;

    public void addSubscriber(Subscriber subscriber){

        eventBus.register(subscriber);
    }

    public void on(){

    }

    public void off(){

    }

    public void charge(){

    }

    public void eject(){

    }



}
