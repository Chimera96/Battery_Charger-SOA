import com.google.common.eventbus.EventBus;
/**
 * Created by bernd on 21.02.2017.
 */
public class BatteryCharger {

    private String name, type;
    private EventBus eventBus;
    private int eventID;

    public BatteryCharger() {
        this.eventBus = new EventBus();
    }

    public void addSubscriber(Subscriber subscriber){
        eventBus.register(subscriber);
    }

    public void on(){
        eventBus.post(new OnEvent(eventID++));
    }

    public void off(){
        eventBus.post(new OffEvent(eventID++));
    }

    public void charge(){
        eventBus.post(new ChargeEvent(eventID++));
    }

    public void eject(){
        eventBus.post(new EjectEvent(eventID++));
    }
}
