package ApplyToProject.Ex1.Observer;

public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyAllObserver();
}