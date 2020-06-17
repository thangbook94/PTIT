package ApplyToProject.Ex5.CommandPattern;


public class ViewCommand implements Command {

    private final OrderReceiver receiver;

    public ViewCommand(OrderReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.viewOrder();
    }
}
