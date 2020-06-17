package Question4.Builder;

public class Waiter {
    private CakeBuilder cakeBuilder;

    public void setCakeBuilder(CakeBuilder cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    public Cake getCake() {
        return cakeBuilder.getCake();
    }

    public void genCake() {
        cakeBuilder.createNewCake();
        cakeBuilder.buidlDough();
        cakeBuilder.buidlFrosting();
        cakeBuilder.buidlTopping();
    }
}
