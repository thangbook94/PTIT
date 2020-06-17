package Pattern.Cart;

public class ConcreteCartSubject extends CartSubject {

    private CartStateContext subjectstate;

    public ConcreteCartSubject() {
        super();
    }

    public CartStateContext GetState() {
        return subjectstate;
    }

    public void SetState(CartStateContext state) {
        subjectstate = state;
        super.getCart().setCartStateContext(state);
        super.Notify();
    }

}
