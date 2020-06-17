package Pattern.Cart;

import java.util.List;

public class Cart {

    private int quanitity;
    private float amount;
    private CartStateContext state;

    public Cart() {
    }

    public Customer getCustomer(Customer c) {
        return c;
    }

    public List getItems(List<Item> items) {
        return items;
    }

    public void setCartStateContext(CartStateContext context) {
        state = context;
    }

    public CartStateContext getState() {
        return state;
    }

}
