/**
 * Created by bernd on 21.02.2017.
 */

import com.google.common.eventbus.*;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class BatteryMediator extends Subscriber {
    private String identifier;
    private Object port;

    public BatteryMediator(String identifier) {
        createBatteryPortInstance();
        this.identifier = identifier;
    }

    private void createBatteryPortInstance() {
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
    }

    public boolean execute_charge(String operation) {
        boolean result = false;
        try {
            Method method = port.getClass().getMethod(operation);
            result = (boolean)method.invoke(port);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    public boolean execute_eject(String operation) {
        boolean result = false;
        try {
            Method method = port.getClass().getMethod(operation);
            result = (boolean)method.invoke(port);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    @Subscribe
    public void receive(OnEvent event) {
        BatteryCharger.setPower(true);
        System.out.println(event);
    }

    @Subscribe
    public void receive(OffEvent event) {
        BatteryCharger.setPower(false);
        System.out.println(event);
    }

    @Subscribe
    public void receive(ChargeEvent event) {
        if(BatteryCharger.getPower() == true) {
            execute_charge("charge");
            System.out.println(event);
        } else
            System.out.println("BatteryCharger turned off!");
    }

    @Subscribe
    public void receive(EjectEvent event) {
        if(BatteryCharger.getPower() == true) {
            execute_eject("eject");
            System.out.println(event);
        } else
            System.out.println("BatteryCharger turned off!");
    }
}
