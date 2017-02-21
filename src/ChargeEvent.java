/**
 * Created by christoph on 21.02.17.
 */

public class ChargeEvent {
    private int id;

    public ChargeEvent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ EventCharge : ");
        stringBuilder.append("id = ").append(id).append(" }");
        return stringBuilder.toString();
    }
}
