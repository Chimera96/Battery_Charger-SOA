public class Application {

    public static void main(String... args) {
        BatteryCharger batteryCharger = new BatteryCharger();

        batteryCharger.addSubscriber(new BatteryMediator("batteries"));
        batteryCharger.on();
        batteryCharger.charge();
        batteryCharger.eject();
        batteryCharger.off();
    }
}