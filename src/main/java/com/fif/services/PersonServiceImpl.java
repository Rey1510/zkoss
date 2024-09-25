package com.fif.services;

import com.fif.Entity.Person;
import com.fif.Repository.PersonRepository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private List<Person> personList;

    public PersonServiceImpl() {
        this.personRepository = new PersonRepository();
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> search(String keyword) {
        return personList.parallelStream()
                .filter(person -> keyword == null || keyword.isEmpty()
                || person.getUsername().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        List<Person> personList = personRepository.findAll();
        personList.removeIf(person -> Objects.equals(person.getId(), id));
    }

    @Override
    public void add(String username, String email, String password, String gender, Date birthday, int age, String jabodetabek){
        personRepository.add(new Person(UUID.randomUUID().toString(), username, email, password, gender, birthday,age, jabodetabek));
    }


    @Override
    public void update(String id, String username, String email, String gender, Date birthday, int age, String jabodetabek) {
        List<Person> personList = personRepository.findAll();
        for (Person p : personList) {
            if (p.getId().equals(id)) {
                p.setUsername(username);
                p.setEmail(email);
                p.setGender(gender);
                p.setBirthday(birthday);
                p.setAge(age);
                p.setJabodetabek(jabodetabek);
                break;
            }
        }
    }

}


