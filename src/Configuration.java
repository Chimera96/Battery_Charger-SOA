

import java.io.FileInputStream;
import java.util.Properties;
public enum Configuration {
    instance;

    public BatteryType capacityType = BatteryType.normal;
    public String userDirectory = System.getProperty("user.dir");
    public String pathToJar = userDirectory + "/" + getLightType() + "/" + "Battery.jar";

    public BatteryType getLightType() {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(userDirectory + "/" + "battery.props");
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("batteryType").equals("normal"))
                return BatteryType.normal;
            else if (properties.getProperty("batteryType").equals("sup3r"))
                return BatteryType.sup3r;
            else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}