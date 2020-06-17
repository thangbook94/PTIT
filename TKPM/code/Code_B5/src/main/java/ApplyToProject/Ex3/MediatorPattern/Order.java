package ApplyToProject.Ex3.MediatorPattern;

public class Order extends Component {

    public Order(NotificationMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String msg, String reicever) {
        System.out.println("---");
        System.out.println(this.name + ": " + msg);
        mediator.sendMessage(msg, this, reicever);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " received : " + msg);
    }

}
