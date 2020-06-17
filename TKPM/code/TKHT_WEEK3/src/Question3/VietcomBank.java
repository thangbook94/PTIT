package Question3;

public class VietcomBank implements Bank {
    @Override
    public String getBankName() {
        return "VietcomBank";
    }

    @Override
    public float getInterestRate() {
        return 0.6f;
    }

    @Override
    public int getWithdrawFee() {
        return 8720000;
    }
}

