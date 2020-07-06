/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SA Nice
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String address;
    private int typeUserId;
    private String email;
    private String lastName;

    public User() {
    }

    public User(String username, String password, String name, String address, int typeUserId, String email, String lastName) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.typeUserId = typeUserId;
        this.email = email;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(int typeUserId) {
        this.typeUserId = typeUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", address=" + address + ", typeUserId=" + typeUserId + ", email=" + email + ", lastName=" + lastName + '}';
    }
    
    
}
