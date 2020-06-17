package Question4.Builder;

public class MainApp {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        CakeBuilder socolaCakeBuilder = new SocolaCakeBuilder();
        CakeBuilder kiwiCakeBuilder = new KiwiCakeBuilder();
        waiter.setCakeBuilder(socolaCakeBuilder);
        waiter.genCake();
        Cake cake = waiter.getCake();
        System.out.println(cake);
    }
}
