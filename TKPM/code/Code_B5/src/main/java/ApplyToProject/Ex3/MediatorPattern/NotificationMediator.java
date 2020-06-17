package ApplyToProject.Ex3.MediatorPattern;

public interface NotificationMediator {

    void sendMessage(String msg, Component component, String receiver);

    void addComponent(Component component);
}
