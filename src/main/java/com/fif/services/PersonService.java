package com.fif.services;

import com.fif.Entity.Person;

import java.util.Date;
import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    public List<Person> search(String keyword);
    public void delete(String id);
    public void add(String username, String email, String password, String gender, Date birthday, int age, String jabodetabek);
    public void update(String id, String username, String email, String gender, Date birthday, int age, String jabodetabek);
}