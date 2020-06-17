package com.example.recyclerview1;

public class Person {
    private String name;
    private String surName;
    private String preference;

    public Person(String name, String surName, String preference) {
        this.name = name;
        this.surName = surName;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
