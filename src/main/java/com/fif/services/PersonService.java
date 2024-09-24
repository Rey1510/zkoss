package com.fif.services;

import com.fif.Entity.Person;

import java.sql.Date;
import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    public List<Person> search(String keyword);
    public void delete(int id);
    public void add(int id, String username, String email, String password, String gender, Date birthday, int age, String jabodetabek);
}