package ApplyToProject.Ex1.Observer;

import java.util.ArrayList;
import java.util.List;

public class ItemService implements Subject {
    private final Item item;
    private List<Observer> observers = new ArrayList<>();

    public ItemService(String name, int price) {
        item = new Item();
        item.setName(name);
        item.setPrice(price);
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(item);
        }
    }

    public void changeStatus(ItemStatus status) {
        item.setItemStatus(status);
        System.out.println("Item Status is changed");
        this.notifyAllObserver();
    }
}
