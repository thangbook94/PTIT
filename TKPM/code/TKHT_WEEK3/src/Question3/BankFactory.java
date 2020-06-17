package Question3;

public class BankFactory {
    public static final Bank getBank(BankType bankType) {
        switch (bankType) {
            case TPBANK:
                return new TPBank();
            case VPBANK:
                return new VPBank();
            case TECHCOMBANK:
                return new TechcomBank();
            case VIETCOMBANK:
                return new VietcomBank();
            default:
                throw new IllegalArgumentException("Not support this bank");
        }
    }
}
