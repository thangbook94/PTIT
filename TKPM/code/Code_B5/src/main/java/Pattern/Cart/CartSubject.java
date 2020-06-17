package Pattern.Cart;

import java.util.ArrayList;

public abstract class CartSubject {

    private Cart cart;
    private ArrayList<Observer> observers = new ArrayList<>();

    public CartSubject() {
        System.out.println("create Pattern.Cart Subject");
        cart = new Cart();
        cart.setCartStateContext(new CartStateContext());
    }


    public void Attach(Observer observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    public void Detach(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void Notify() {
        for (Observer observer : observers) {
            observer.Update(cart);
        }
    }

    public Cart getCart() {
        return cart;
    }

}
