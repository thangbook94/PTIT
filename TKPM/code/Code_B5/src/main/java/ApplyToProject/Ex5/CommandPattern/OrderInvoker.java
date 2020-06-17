package ApplyToProject.Ex5.CommandPattern;

public class OrderInvoker {

    private Command viewCommand;
    private Command cancelCommand;

    public OrderInvoker(Command viewCommand, Command cancelCommand) {
        this.viewCommand = viewCommand;
        this.cancelCommand = cancelCommand;
    }

    public void view() {
        viewCommand.execute();
    }

    public void cancel() {
        cancelCommand.execute();
    }
}
