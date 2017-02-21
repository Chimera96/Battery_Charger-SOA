public class Application {

    public static void main(String... args) {
        BatteryCharger batteryCharger = new BatteryCharger();

        batteryCharger.addSubscriber(new BatteryMediator());
        batteryCharger.on();
        batteryCharger.charge();
        batteryCharger.eject();
        batteryCharger.off();
    }
}