package Question3;

public class VPBank implements Bank {
    @Override
    public String getBankName() {
        return "VPBank";
    }

    @Override
    public float getInterestRate() {
        return 0.3f;
    }

    @Override
    public int getWithdrawFee() {
        return 530000;
    }
}
