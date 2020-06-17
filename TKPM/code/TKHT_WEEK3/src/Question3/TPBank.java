package Question3;

public class TPBank implements Bank {
    @Override
    public String getBankName() {
        return "TPBank";
    }

    @Override
    public float getInterestRate() {
        return 0.1f;
    }

    @Override
    public int getWithdrawFee() {
        return 100000;
    }
}
