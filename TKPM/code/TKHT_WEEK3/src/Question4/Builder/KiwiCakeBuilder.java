package Question4.Builder;

public class KiwiCakeBuilder extends CakeBuilder {


    @Override
    public void buidlDough() {
        cake.setDough("kiwi dough");
    }

    @Override
    public void buidlFrosting() {
        cake.setFrosting("kiwi frosting");
    }

    @Override
    public void buidlTopping() {
        cake.setTopping("kiwi topping");
    }

}
