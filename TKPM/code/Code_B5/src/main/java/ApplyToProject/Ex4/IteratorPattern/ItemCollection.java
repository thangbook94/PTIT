package ApplyToProject.Ex4.IteratorPattern;

import java.util.ArrayList;

public class ItemCollection implements Collection {

    private ArrayList<Item> items;

    public ItemCollection() {
        items = new ArrayList<>();
        items.add(new Item("Truyen Conan", 10000L, "Tham tu lung danh conan"));
        items.add(new Item("MiBand4", 600000L, "Vong tay Xiao mi miband 4"));
        items.add(new Item("TabletA30", 3200000L, "May tinh bang SamSung A30"));
    }

    @Override
    public Iterator createIterator() {
        return new ItemIterator(items);
    }

}
