package ru.sgu.presentation.directory;

import java.util.Date;
import java.util.UUID;

public class User {

    private int id;

    private String name;

    private String phoneNumber;

    private int age;

    public User() {
    }

    public User(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nИмя: %s\nНомер: %s\nВозраст: %s", this.id, this.name, this.phoneNumber, this.age);
    }
}
