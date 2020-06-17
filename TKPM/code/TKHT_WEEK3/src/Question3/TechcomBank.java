package Question3;

public class TechcomBank implements Bank {
    @Override
    public String getBankName() {
        return "TechcomBank";
    }

    @Override
    public float getInterestRate() {
        return 0.2f;
    }

    @Override
    public int getWithdrawFee() {
        return 220000;
    }
}
