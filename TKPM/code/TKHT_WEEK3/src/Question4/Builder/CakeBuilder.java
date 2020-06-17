package Question4.Builder;

public abstract class CakeBuilder {
    protected Cake cake;

    public abstract void buidlDough();

    public abstract void buidlFrosting();

    public abstract void buidlTopping();

    public Cake getCake() {
        return cake;
    }

    public void createNewCake() {
        cake = new Cake();
    }
}
