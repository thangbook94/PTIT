package Question4.Builder;

public class Cake {
    private String dough;
    private String frosting;
    private String topping;

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setFrosting(String frosting) {
        this.frosting = frosting;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "dough='" + dough + '\'' +
                ", frosting='" + frosting + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}
