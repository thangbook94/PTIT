package Pattern.Observer;

public class Phoner implements Observer {

    @Override
    public void update(User user) {
        if (user.getStatus() == LoginStatus.EXPIRED) {
            System.out.println("Phoner: User "
                    + user.getPhoneNumber()
                    + " is expired. An message was sent!");
        }
    }
}
