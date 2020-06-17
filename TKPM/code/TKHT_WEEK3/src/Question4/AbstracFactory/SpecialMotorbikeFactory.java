package Question4.AbstracFactory;

public class SpecialMotorbikeFactory extends AbstractFactory {
    @Override
    Motorbike getMotobike(MotorbikeType motorbikeType) {
        switch (motorbikeType) {
            case HONDA:
                return new SpecialHonda();
            case YAMAHA:
                return new SpecialYamaha();
        }
        return null;
    }
}
