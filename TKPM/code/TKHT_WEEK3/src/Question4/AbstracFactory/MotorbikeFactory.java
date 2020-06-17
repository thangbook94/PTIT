package Question4.AbstracFactory;

public class MotorbikeFactory extends AbstractFactory {
    @Override
    Motorbike getMotobike(MotorbikeType motorbikeType) {
        switch (motorbikeType) {
            case HONDA:
                return new Honda();
            case YAMAHA:
                return new Yamaha();
        }
        return null;
    }
}
