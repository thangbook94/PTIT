package Question4.AbstracFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(MotorbikeVersion motorbikeVersion) {
        switch (motorbikeVersion) {
            case NORMAL:
                return new MotorbikeFactory();
            case SPECIAL:
                return new SpecialMotorbikeFactory();

        }
        return null;
    }
}
