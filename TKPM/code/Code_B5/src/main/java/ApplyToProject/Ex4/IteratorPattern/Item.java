package ApplyToProject.Ex4.IteratorPattern;

public class Item {

    private String name;
    private long price;
    private String description;

    public Item(String name, long price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", price=" + price + ", description=" + description + '}';
    }

}
