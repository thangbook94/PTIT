package ApplyToProject.Ex1.Observer;

class User implements Observer {
    private String id;
    private String email;
    private String phoneNumber;

    public User() {
    }

    public User(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    @Override
    public void update(Item item) {
        System.out.println("User" + this.email + " has notification :Item " + item.getName() + " has update status " + item.getItemStatus());
    }
}
 
