package ApplyToProject.Ex2.Strategy;

public class Shipping {
    private String startDate;
    private String totalAmount;
    private ShippingStrategy strategy;
    private int price;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ShippingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }
}
