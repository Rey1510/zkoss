package com.fif.Repository;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fif.Entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Person> queryAll() {
        Query query = em.createQuery("SELECT p FROM Person p");
        List<Person> result = query.getResultList();
        return result;
    }

    @Transactional(readOnly = true)
    public Person get(Long id){
        return em.find(Person.class, id);
    }

    @Transactional
    public Person save(Person person) {
        em.persist(person);
        em.flush();
        return person;
    }

    @Transactional
    public void delete(Person person) {
        Person p = get(person.getId());
        if(p != null) {
            em.remove(p);
        }
    }

    @Transactional(readOnly = true)
    public List<Person> searchByKeyword(String keyword) {
        String searchQuery = "SELECT p FROM Person p WHERE p.username LIKE :keyword";
        Query query = em.createQuery(searchQuery);
        query.setParameter("keyword", "%" + keyword + "%");
        List<Person> res = query.getResultList();
        return res;
    }

    @Transactional
    public void updatePerson(Person person, String username, String email, String gender, Date birthday, int age, String jabodetabek) {
        Person existingPer = get(person.getId());
        existingPer.setUsername(username);
        existingPer.setEmail(email);
        existingPer.setGender(gender);
        existingPer.setBirthday(birthday);
        existingPer.setAge(age);
        existingPer.setJabodetabek(jabodetabek);
        em.merge(existingPer);
    }
}
