package com.fif.services;

import com.fif.Entity.Person;
import com.fif.Repository.PersonRepository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonRepository personList = new PersonRepository();

    public PersonServiceImpl() {
        this.personRepository = new PersonRepository();
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> search(String keyword) {
        List<Person> result = new ArrayList<>();
        List<Person> personList = personRepository.findAll();

        if (keyword == null || keyword.isEmpty()){
            result = personList;
        }else{
            for (Person p: personList){
                if(p.getUsername().toLowerCase().contains(keyword.toLowerCase())){
                    result.add(p);
                }
            }
        }
        return result;
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

}


