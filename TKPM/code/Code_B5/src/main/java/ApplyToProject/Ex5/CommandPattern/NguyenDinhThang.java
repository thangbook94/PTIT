package ApplyToProject.Ex5.CommandPattern;

public class NguyenDinhThang {

    public static void main(String[] args) {
        OrderReceiver receiver = new OrderReceiver(6789);
        OrderInvoker invoker = new OrderInvoker(new ViewCommand(receiver), new CancelCommand(receiver));
        invoker.view();
        invoker.cancel();
    }
}
