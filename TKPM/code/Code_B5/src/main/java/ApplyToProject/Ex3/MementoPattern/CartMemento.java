package ApplyToProject.Ex3.MementoPattern;


public class CartMemento {

    private Cart cart;

    public CartMemento(Cart cart) {
        this.cart = cart;
    }

    public Cart getDocument() {
        return cart;
    }
}
