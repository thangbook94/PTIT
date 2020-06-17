package com.example.sqlitedemo;


public class Student {
    public Student() {
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;
    private String number;
    private String email;

    public Student(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public Student(int id, String name, String number, String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.email = email;
    }

    @Override
    public String toString() {

        return "Name:" + getName() + " \n" + "Number: " + getNumber() + "\n" + "Email: " + getEmail();
    }
}
