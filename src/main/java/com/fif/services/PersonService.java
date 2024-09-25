package com.fif.services;

import com.fif.Entity.Person;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PersonService {
    Person addPerson(Person person);

    List<Person> getPerson();

    void deletePerson(Person person);

    public List<Person> searchPersonsByKeyword(String keyword);

    public void update(Person person, String username, String email, String gender, Date birthday, int age, String jabodetabek);

//    public List<Person> findAll();
//    public List<Person> search(String keyword);
//    public void delete(Long id);
//    public void add(String username, String email, String password, String gender, Date birthday, int age, String jabodetabek);
//    public void update(Long id, String username, String email, String gender, Date birthday, int age, String jabodetabek);
}