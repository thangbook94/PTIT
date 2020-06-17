package Pattern.Cart;

public class CartStateContext {

    private CartState state;

    public CartStateContext() {
        this.state = new EmptyCart();

    }

    public CartState getState() {
        return state;
    }

    public void setState(CartState state) {
        this.state = state;
    }

}
