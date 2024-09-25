package com.fif.services.impl;

import com.fif.Entity.Person;
import com.fif.Repository.PersonRepository;
import com.fif.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;


@Service("personService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repo;

    @Transactional
    public Person addPerson(Person person) {
        return repo.save(person);
    }

    public List<Person> getPerson(){
        return repo.queryAll();
    }

    public void update(Person person, String username, String email, String gender, Date birthday, int age, String jabodetabek) {
        repo.updatePerson(person,username,email,gender,birthday,age,jabodetabek);
    }

    public void deletePerson(Person person) {
        repo.delete(person);
    }

    public List<Person> searchPersonsByKeyword(String keyword) {
        return repo.searchByKeyword(keyword);
    }



//    private PersonRepository personRepository;
//    private List<Person> personList;
//
//    public PersonServiceImpl() {
//        this.personRepository = new PersonRepository();
//    }
//
//    @Override
//    public List<Person> findAll() {
//        return personRepository.findAll();
//    }
//
//    @Override
//    public List<Person> search(String keyword) {
//        return personList.parallelStream()
//                .filter(person -> keyword == null || keyword.isEmpty()
//                || person.getUsername().toLowerCase().contains(keyword.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void delete(Long id) {
//        List<Person> personList = personRepository.findAll();
//        personList.removeIf(person -> Objects.equals(person.getId(), id));
//    }
//
//    @Override
//    public void add(String username, String email, String password, String gender, Date birthday, int age, String jabodetabek){
//        personRepository.add(new Person(username, email, password, gender, birthday,age, jabodetabek));
//    }
//
//
//    @Override
//    public void update(Long id, String username, String email, String gender, Date birthday, int age, String jabodetabek) {
//        List<Person> personList = personRepository.findAll();
//        for (Person p : personList) {
//            if (p.getId().equals(id)) {
//                p.setUsername(username);
//                p.setEmail(email);
//                p.setGender(gender);
//                p.setBirthday(birthday);
//                p.setAge(age);
//                p.setJabodetabek(jabodetabek);
//                break;
//            }
//        }
//    }
}


