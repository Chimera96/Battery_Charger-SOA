/**
 * Created by christoph on 21.02.17.
 */

public class OnEvent {
    private int id;

    public OnEvent(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ EventOn : ");
        stringBuilder.append("id = ").append(id).append(" }");
        return stringBuilder.toString();
    }
}
