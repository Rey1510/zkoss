package com.fif.services;

import com.fif.Entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private List<Person> personList = new ArrayList<Person>();

    private int id = 1;

    public PersonServiceImpl() {
        personList.add
                (new Person(id++,"john_doe", "john@example.com", "password123", "Male", "1990-01-01", 34, "Jakarta"));
        personList.add
                ( new Person(id++,"jane_smith", "jane@example.com", "password456", "Female", "1992-02-02", 32, "Bogor"));
        personList.add
                ( new Person(id++,"mike_johnson", "mike@example.com", "password789", "Male", "1988-03-03", 36, "Depok"));
        personList.add
                ( new Person(id++,"sara_connor", "sara@example.com", "password000", "Female", "1995-04-04", 29, "Tangerang"));
        personList.add
                ( new Person(id++,"alex_brown", "alex@example.com", "password111", "Non-binary", "1993-05-05", 31, "Bekasi"));
        personList.add
                ( new Person(id++,"lisa_wilson", "lisa@example.com", "password222", "Female", "1985-06-06", 39, "Jakarta"));
        personList.add
                ( new Person(id++,"kevin_white", "kevin@example.com", "password333", "Male", "1991-07-07", 33, "Bogor"));
        personList.add
                ( new Person(id++,"nina_green", "nina@example.com", "password444", "Female", "1987-08-08", 37, "Depok"));
        personList.add
                ( new Person(id++,"chris_black", "chris@example.com", "password555", "Male", "1994-09-09", 30, "Tangerang"));
        personList.add
                ( new Person(id++,"diana_red", "diana@example.com", "password666", "Female", "1996-10-10", 28, "Bekasi"));
        personList.add
                ( new Person(id++,"tom_hanks", "tom@example.com", "password777", "Male", "1980-11-11", 43, "Jakarta"));
        personList.add
                ( new Person(id++,"cathy_james", "cathy@example.com", "password888", "Female", "1993-12-12", 30, "Bogor"));
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public List<Person> search(String keyword) {
        List<Person> result = new ArrayList<Person>();
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
