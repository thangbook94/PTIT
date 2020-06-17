package ApplyToProject.Ex2.TemplatePattern;


public class Item {

    private String name;
    private long price;
    private String description;

    public Item(String name, long price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", price=" + price + ", description=" + description + '}';
    }

}
