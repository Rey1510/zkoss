package com.fif.services;

import com.fif.Entity.Person;

import java.util.List;

public interface PersonService {
    public List<Person> findAll();
    public List<Person> search(String keyword);
}
