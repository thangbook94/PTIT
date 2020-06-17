package ApplyToProject.Ex3.MediatorPattern;

public class NguyenDinhThang {

    public static void main(String[] args) {
        NotificationMediator notificationMediator = new NotificationMediatorImpl("Notification Mediator For Order No.0022");

        Component order = new Order(notificationMediator, "OrderNo0022");
        Component customer = new Customer(notificationMediator, "Customer275");
        Component staff = new Staff(notificationMediator, "Staff6032");

        notificationMediator.addComponent(customer);
        notificationMediator.addComponent(order);
        notificationMediator.addComponent(staff);

        order.send("Order is created and need staff check", "staff");
        staff.send("Staff is checking order...", "all");
    }
}
