package ApplyToProject.Ex5.CommandPattern;


public class CancelCommand implements Command {

    private final OrderReceiver receiver;

    public CancelCommand(OrderReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.cancelOrder();
    }
}
