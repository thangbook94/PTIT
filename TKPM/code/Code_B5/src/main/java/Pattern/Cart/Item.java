package Pattern.Cart;

public class Item {

    private String name;
    private int quanitity;
    private float sellPrice;
    private float star;

    public Item(String name, int quanitity, float sellPrice, float star) {
        this.name = name;
        this.quanitity = quanitity;
        this.sellPrice = sellPrice;
        this.star = star;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuanitity() {
        return this.quanitity;
    }

    public void setQuanitity(int quanitity) {
        this.quanitity = quanitity;
    }

    public float getSellPrice() {
        return this.sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getStar() {
        return this.star;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
