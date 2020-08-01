package nhom7.thh.meomeonote.entity;

public class User {
    private int id;
    private String phoneNumber;
    private String password;
    private int status;

    public User() {
    }

    public User(int id, String phoneNumber, String password, int status) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
