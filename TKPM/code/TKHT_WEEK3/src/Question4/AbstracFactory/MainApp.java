package Question4.AbstracFactory;

public class MainApp {
    public static void main(String[] args) {
        AbstractFactory normalFactory = FactoryProducer.getFactory(MotorbikeVersion.NORMAL);
        Motorbike motorbike = normalFactory.getMotobike(MotorbikeType.HONDA);
        motorbike.buidMotobike();
        Motorbike motorbike2 = normalFactory.getMotobike(MotorbikeType.YAMAHA);
        motorbike2.buidMotobike();
        AbstractFactory specialFactory = FactoryProducer.getFactory(MotorbikeVersion.SPECIAL);
        Motorbike motorbike3 = specialFactory.getMotobike(MotorbikeType.HONDA);
        motorbike3.buidMotobike();
        Motorbike motorbike4 = specialFactory.getMotobike(MotorbikeType.YAMAHA);
        motorbike4.buidMotobike();
    }
}
