/**
 * Created by christoph on 21.02.17.
 */

public class EjectEvent {
    private int id;

    public EjectEvent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ EventEject : ");
        stringBuilder.append("id = ").append(id).append(" }");
        return stringBuilder.toString();
    }
}
