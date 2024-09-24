package com.fif.Entity;

import java.util.Date;

public class Person {
    private int id;
    private String username;
    private String email;
    private String password;
    private String gender;
    private Date birthday;
    private int age;
    private String jabodetabek;

    public Person(int id, String username, String email, String password, String gender, Date birthday, int age, String jabodetabek) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.jabodetabek = jabodetabek;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJabodetabek() {
        return jabodetabek;
    }

    public void setJabodetabek(String jabodetabek) {
        this.jabodetabek = jabodetabek;
    }
}
