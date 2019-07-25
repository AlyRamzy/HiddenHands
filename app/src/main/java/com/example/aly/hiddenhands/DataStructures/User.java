package com.example.aly.hiddenhands.DataStructures;

/**
 * Created by Nour Ahmed on 7/24/2019.
 */

public class User {
    private int age;
    private char gender;
    private String username;
    private int type;              //1->patient   2->doctor

    public User(int age, char gender, String username, int type) {
        this.age = age;
        this.gender = gender;
        this.username = username;
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public int getType() {
        return type;
    }
}
