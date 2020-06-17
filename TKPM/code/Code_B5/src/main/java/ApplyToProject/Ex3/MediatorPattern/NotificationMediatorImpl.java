package ApplyToProject.Ex3.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class NotificationMediatorImpl implements NotificationMediator {

    private List<Component> components = new ArrayList<>();

    public NotificationMediatorImpl(String groupName) {
    }

    @Override
    public void addComponent(Component component) {
        System.out.println("Add " + component.name + "to this Notification Mediator");
        this.components.add(component);
    }

    @Override
    public void sendMessage(String msg, Component component, String receiver) {
        switch (receiver) {
            case "all": {
                for (Component c : this.components) {
                    if (!c.equals(component)) {
                        c.receive(msg);
                    }
                }
                break;
            }
            case "customer": {
                for (Component c : this.components) {
                    if (c instanceof Customer) {
                        c.receive(msg);
                    }
                }
                break;
            }
            case "order": {
                for (Component c : this.components) {
                    if (c instanceof Order) {
                        c.receive(msg);
                    }
                }
                break;
            }
            case "staff": {
                for (Component c : this.components) {
                    if (c instanceof Staff) {
                        c.receive(msg);
                    }
                }
                break;
            }
        }
    }
}
