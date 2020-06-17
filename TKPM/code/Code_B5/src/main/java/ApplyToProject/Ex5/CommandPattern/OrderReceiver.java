package ApplyToProject.Ex5.CommandPattern;

public class OrderReceiver {

    private int id;

    public OrderReceiver(int id) {
        this.id = id;
    }

    public void viewOrder() {
        System.out.println("View infomation of Order No." + id);
    }

    public void cancelOrder() {
        System.out.println("Cancel Order No." + id);
    }
}
