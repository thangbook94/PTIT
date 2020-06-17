package Pattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class AccountService implements Subject {
    private User user;
    private List<Observer> observers = new ArrayList<>();

    public AccountService(String email, String phoneNumber) {
        user = new User();
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(user);
        }
    }

    public void changeStatus(LoginStatus status) {
        user.setStatus(status);
        System.out.println("Status is changed");
        this.notifyAllObserver();
    }

    public void login() {

        if (this.isValidEmail()) {
            user.setStatus(LoginStatus.SUCCESS);
        } else {
            user.setStatus(LoginStatus.FAILURE);
        }

        System.out.println("Login is handled");
        this.notifyAllObserver();
    }

    private boolean isValidEmail() {
        return "contact@gpcoder.com".equalsIgnoreCase(user.getEmail());
    }
}
