public class Battery {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isCharged = false;
    private static Battery instance = new Battery();
    private int status = 0; // 0 = ejected | 1 = charging
    public Port port;

    public Battery() {
        this.port = new Port();
    }

    public static Battery getInstance() {
        return instance;
    }

    public class Port implements IBattery {

        @Override
        public boolean charge() {
            isCharged = true;
            status = 1;
            return isCharged;
        }

        @Override
        public void eject() {
            status = 0;
        }
    }
}