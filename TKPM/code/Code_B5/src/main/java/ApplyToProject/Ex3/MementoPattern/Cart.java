package ApplyToProject.Ex3.MementoPattern;

import java.util.List;

public class Cart {

    private List<Item> item;

    public Cart(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cart{" + "item=" + item + '}';
    }

}
