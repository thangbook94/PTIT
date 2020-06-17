package ApplyToProject.Ex2.TemplatePattern;

import java.util.ArrayList;

public abstract class ListItemsTemplate {

    protected ArrayList<Item> items;

    public ListItemsTemplate() {
        items = new ArrayList<>();
        items.add(new Item("Truyen Conan", 10000L, "Tham tu lung danh conan"));
        items.add(new Item("MiBand4", 600000L, "Vong tay Xiao mi miband 4"));
        items.add(new Item("TabletA30", 3200000L, "May tinh bang SamSung A30"));
    }

    protected void showTitle() {
        System.out.println("List Items in Order:");
    }

    protected abstract void showItems();

    protected void showTotalPrice() {
        long total = items.stream().mapToLong(i -> i.getPrice()).sum();
        System.out.println("----------Total Price: " + total);
    }

    public void showListItems() {
        showTitle();
        showItems();
        showTotalPrice();
    }
}
