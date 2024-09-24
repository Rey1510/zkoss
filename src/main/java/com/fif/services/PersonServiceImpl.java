package com.fif.services;

import com.fif.Entity.Person;
import com.fif.Repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl() {
        this.personRepository = personRepository;
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
}
