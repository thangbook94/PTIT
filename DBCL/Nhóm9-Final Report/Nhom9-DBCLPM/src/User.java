
import java.sql.Date;

public class User {

    private String cmt;
    private String password;
    private String email;
    private String hoten;
    private String date;
    private String status;
    private int region;
    private double salary;
    private double allowance;
    private String train, warning, type;
    private double money;
    private String statuscal;

    public User() {

    }

    public User(String cmt, double money, String statuscal) {
        this.cmt = cmt;
        this.money = money;
        this.statuscal = statuscal;
    }

    public User(String cmt, String password, String email, String hoten, String date, String status, String statuscal) {
        this.cmt = cmt;
        this.password = password;
        this.email = email;
        this.hoten = hoten;
        this.date = date;
        this.status = status;
        this.statuscal = statuscal;
    }

    public User(String cmt, String status, int region, double salary, double allowance, String train, String warning, String type) {
        this.cmt = cmt;
        this.status = status;
        this.region = region;
        this.salary = salary;
        this.allowance = allowance;
        this.train = train;
        this.warning = warning;
        this.type = type;

    }

    public User(String cmt, String password, String email, String hoten, String date, String status, int region, long salary, long allowance, String train, String warning, String type) {
        this.cmt = cmt;
        this.password = password;
        this.email = email;
        this.hoten = hoten;
        this.date = date;
        this.status = status;
        this.region = region;
        this.salary = salary;
        this.allowance = allowance;
        this.train = train;
        this.warning = warning;
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getStatuscal() {
        return statuscal;
    }

    public void setStatuscal(String statuscal) {
        this.statuscal = statuscal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
