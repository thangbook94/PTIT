package ApplyToProject.Ex3.MementoPattern;

public class CartOriginator {

    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartMemento save() {
        return new CartMemento(cart);
    }

    public void revert(CartMemento memento) {
        cart = memento.getDocument();
    }
}
