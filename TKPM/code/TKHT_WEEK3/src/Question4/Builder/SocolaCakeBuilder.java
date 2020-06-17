package Question4.Builder;

public class SocolaCakeBuilder extends CakeBuilder {
    @Override
    public void buidlDough() {
        cake.setDough("socola dough");
    }

    @Override
    public void buidlFrosting() {
        cake.setFrosting("socola frosting");
    }

    @Override
    public void buidlTopping() {
        cake.setTopping("socola topping");
    }
}
