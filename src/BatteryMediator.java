/**
 * Created by bernd on 21.02.2017.
 */

import com.google.common.eventbus.Subscribe;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class BatteryMediator extends Subscriber {

    private ArrayList<Object> batteryPorts;

    public BatteryMediator(){
        batteryPorts = new ArrayList<>();
    }

    public void add(BatteryCharger batteryCharger){
        batteryPorts.addAll(batteryCharger.get)
    }

}
