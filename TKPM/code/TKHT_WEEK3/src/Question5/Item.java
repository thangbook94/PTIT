package Question5;

public class Item {
    private String id;
    private String desc;
    private long salePrice;
    private String date;
    private String name;
    private String promo;
    private String feedback;

    public Item(String id, String desc, long salePrice, String date, String name,
                String promo, String feedback) {
        this.id = id;
        this.desc = desc;
        this.salePrice = salePrice;
        this.date = date;
        this.name = name;
        this.promo = promo;
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", salePrice=" + salePrice +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", promo='" + promo + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
