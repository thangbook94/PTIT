package Question3;

public class Client {
    public static void main(String[] args) {
        Bank bank = BankFactory.getBank(BankType.TECHCOMBANK);
        System.out.println("Bank name: " + bank.getBankName());
        System.out.println("Interest: " + bank.getInterestRate());
        System.out.println("Whithdraw fee: " + bank.getWithdrawFee());
        bank = BankFactory.getBank(BankType.TPBANK);
        System.out.println("Bank name: " + bank.getBankName());
        System.out.println("Interest: " + bank.getInterestRate());
        System.out.println("Whithdraw fee: " + bank.getWithdrawFee());
        bank = BankFactory.getBank(BankType.VIETCOMBANK);
        System.out.println("Bank name: " + bank.getBankName());
        System.out.println("Interest: " + bank.getInterestRate());
        System.out.println("Whithdraw fee: " + bank.getWithdrawFee());
        bank = BankFactory.getBank(BankType.VPBANK);
        System.out.println("Bank name: " + bank.getBankName());
        System.out.println("Interest: " + bank.getInterestRate());
        System.out.println("Whithdraw fee: " + bank.getWithdrawFee());
    }
}
