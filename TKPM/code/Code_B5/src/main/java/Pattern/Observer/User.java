package Pattern.Observer;

enum LoginStatus {
    SUCCESS, FAILURE, INVALID, EXPIRED
}

class User {
    private String email;
    private String phoneNumber;
    private LoginStatus status;

    public User() {
    }

    public User(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public LoginStatus getStatus() {
        return status;
    }

    public void setStatus(LoginStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
 
