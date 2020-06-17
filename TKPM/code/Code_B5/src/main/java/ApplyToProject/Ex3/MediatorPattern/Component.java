package ApplyToProject.Ex3.MediatorPattern;

public abstract class Component {

    protected NotificationMediator mediator;
    protected String name;

    public Component(NotificationMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String msg, String receiver);

    public abstract void receive(String msg);

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;

        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Component c = (Component) obj;
        return name.equals(c.name);
    }
}
