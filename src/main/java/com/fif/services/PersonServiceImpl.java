package com.fif.services;

import com.fif.Entity.Person;
import com.fif.Repository.PersonRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

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
    public void delete(int id) {
        List<Person> personList = personRepository.findAll();
        personList.removeIf(person -> person.getId() == id);
    }

    @Override
    public void add(int id, String username, String email, String password, String gender, Date birthday, int age, String jabodetabek){
        personRepository.add(new Person(id, username, email, password, gender, birthday,age, jabodetabek));
    }

}


