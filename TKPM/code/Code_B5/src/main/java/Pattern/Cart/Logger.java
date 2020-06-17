package Pattern.Cart;

public class Logger extends Observer {

    public void Update(Cart cart) {
        System.out.println("perfom");
        cart.getState().getState().Handle();

    }

}
