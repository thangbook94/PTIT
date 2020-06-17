package ApplyToProject.Ex4.IteratorPattern;

import java.util.ArrayList;

public class ItemIterator implements Iterator {

    private ArrayList<Item> items;
    private int index;

    public ItemIterator(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return index < items.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return items.get(index++);
        }
        return null;
    }
}
