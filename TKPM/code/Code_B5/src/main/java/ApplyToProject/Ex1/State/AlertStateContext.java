package ApplyToProject.Ex1.State;

public class AlertStateContext {

    private ItemShippingState currentState;

    public AlertStateContext() {
        currentState = new Pending();
    }

    public void setState(ItemShippingState state) {
        currentState = state;
    }

    public void alert() {
        currentState.alert(this);
    }
}
