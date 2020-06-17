package Pattern.Observer;

public class NguyenDinhThang1aa {
    public static void main(String[] args) {
        AccountService account1 = createAccount("thang@@gmail.com", "192.168.0.1");
        account1.login();
        account1.changeStatus(LoginStatus.EXPIRED);
        System.out.println("---");
        AccountService account2 = createAccount("thang1@yahoo.com", "192.168.0.12");
        account2.login();
    }

    private static AccountService createAccount(String email, String ip) {
        AccountService account = new AccountService(email, ip);
        account.attach(new Logger());
        account.attach(new Mailer());
        account.attach(new Protector());
        return account;
    }
    //https://gpcoder.com/4747-huong-dan-java-design-pattern-observer/
}
