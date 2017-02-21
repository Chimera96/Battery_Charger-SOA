/**
 * Created by christoph on 21.02.17.
 */

public class OffEvent {
    private int id;

    public OffEvent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ EventOff : ");
        stringBuilder.append("id = ").append(id).append(" }");
        return stringBuilder.toString();
    }
}
