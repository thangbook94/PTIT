package ApplyToProject.Ex2.TemplatePattern;

import java.util.Collections;
import java.util.Comparator;

public class ListItemsOrderByNameASC extends ListItemsTemplate {

    public ListItemsOrderByNameASC() {
        super();
    }

    @Override
    protected void showItems() {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return a.getName().compareTo(b.getName());
            }

        });
        items.forEach(i -> System.out.println(i));
    }

}
