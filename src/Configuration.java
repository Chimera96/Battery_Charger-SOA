

import java.io.FileInputStream;
import java.util.Properties;
public enum Configuration {
    instance;

    public BatteryType capacityType = BatteryType.NormalBattery;
    public String userDirectory = System.getProperty("user.dir");
    public String pathToJar = userDirectory + "/" + getBatteryType() + "/" + "Battery.jar";

    public BatteryType getBatteryType() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(userDirectory + "/" + "battery.props");
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("batteryType").equals("normal"))
                return BatteryType.NormalBattery;
            else if (properties.getProperty("batteryType").equals("super"))
                return BatteryType.SuperBattery;
            else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}