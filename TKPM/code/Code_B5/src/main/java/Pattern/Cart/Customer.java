package Pattern.Cart;

public class Customer {

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
