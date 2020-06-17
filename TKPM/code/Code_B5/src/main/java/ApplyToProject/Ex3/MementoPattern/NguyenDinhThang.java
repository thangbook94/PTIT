package ApplyToProject.Ex3.MementoPattern;

import java.util.ArrayList;
import java.util.List;

public class NguyenDinhThang {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Truyen Conan", 10000L, "Tham tu lung danh conan"));
        items.add(new Item("MiBand4", 600000L, "Vong tay Xiao mi miband 4"));
        items.add(new Item("TabletA30", 3200000L, "May tinh bang SamSung A30"));

        CartOriginator originator = new CartOriginator();
        CareTaker careTaker = new CareTaker();

        originator.setCart(new Cart((List<Item>) items.clone()));
        careTaker.add(originator.save());

        System.out.println(originator.getCart());

        System.out.println("remove item");
        items.remove(0);
        originator.setCart(new Cart((List<Item>) items.clone()));
        System.out.println(originator.getCart());

        System.out.println("revert last action");
        originator.revert(careTaker.get());
        System.out.println(originator.getCart());
    }
}
