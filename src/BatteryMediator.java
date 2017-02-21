/**
 * Created by bernd on 21.02.2017.
 */

import com.google.common.eventbus.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class BatteryMediator extends Subscriber {
    private String identifier;
    private ArrayList<Object> portList;
    private boolean power;



    public BatteryMediator(String identifier) {
        createBatteryPortInstance();
        this.identifier = identifier;
        portList = new ArrayList<>();
        init();
    }

    public void init() {
        for(int i = 0; i < Configuration.instance.maxNumberBatteries; i++) {
            portList.add(createBatteryPortInstance());
        }
    }

    private Object createBatteryPortInstance() {
        Object port = null;

        try {
            Object instance = null;
            URL[] urls = { new File(Configuration.instance.pathToJar).toURI().toURL() };
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Application.class.getClassLoader());
            Class clazz = Class.forName("Battery", true, urlClassLoader);
            System.out.println("clazz     : " + clazz.toString());

            instance = clazz.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            port = clazz.getDeclaredField("port").get(instance);
            System.out.println("port      : " + port.hashCode());

            System.out.println("version   : " + Configuration.instance.getBatteryType());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return port;
    }

    public boolean execute_charge(String operation, int id) {
        boolean result = false;
        try {
            Method method = portList.get(id).getClass().getMethod(operation);
            result = (boolean)method.invoke(portList.get(id));
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    public void execute_eject(String operation, int id) {
        try {
            Method method = portList.get(id).getClass().getMethod(operation);
            method.invoke(portList.get(id));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Subscribe
    public void receive(OnEvent event) {
        power = true;
        System.out.println(event + " Mediator turned on!");
    }

    @Subscribe
    public void receive(OffEvent event) {
        power = false;
        System.out.println(event + " Mediator turned off!");
    }

    @Subscribe
    public void receive(ChargeEvent event) {
        if(power == true) {
            for(int i = 0; i < Configuration.instance.maxNumberBatteries; i++) {
                execute_charge("charge", i);
                System.out.println(event + " Battery charging!");
            }
        } else
            System.out.println("BatteryCharger turned off!");
    }

    @Subscribe
    public void receive(EjectEvent event) {
        if(power == true) {
            for(int i = 0; i < Configuration.instance.maxNumberBatteries; i++) {
                execute_eject("eject", i);
                System.out.println(event + " Battery ejected!");
            }
        } else
            System.out.println("BatteryCharger turned off!");
    }
}
