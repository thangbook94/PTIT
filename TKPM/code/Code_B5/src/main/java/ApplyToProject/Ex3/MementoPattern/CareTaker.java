package ApplyToProject.Ex3.MementoPattern;


import java.util.Stack;

public class CareTaker {

    private Stack<CartMemento> mementoList = new Stack<CartMemento>();

    public void add(CartMemento cart) {
        mementoList.add(cart);
    }

    public CartMemento get() {
        return mementoList.pop();
    }
}
