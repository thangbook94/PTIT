package ApplyToProject.Ex2.TemplatePattern;

import java.util.Collections;
import java.util.Comparator;

public class ListItemsOrderByPriceASC extends ListItemsTemplate {

    public ListItemsOrderByPriceASC() {
        super();
    }

    @Override
    protected void showItems() {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return a.getPrice() > b.getPrice() ? 1 : a.getPrice() == b.getPrice() ? 0 : -1;
            }

        });
        items.forEach(i -> System.out.println(i));
    }

}
