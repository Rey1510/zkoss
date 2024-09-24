package com.fif.Repository;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fif.Entity.Person;

public class PersonRepository {

    public static List<Person> personList = new ArrayList<Person>();

    private static int id = 1;

    static {
        personList.add(new Person(UUID.randomUUID().toString(), "john_doe", "john@example.com", "password123", "Male",
                java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)), 34, "Jakarta"));
        personList.add(new Person(UUID.randomUUID().toString(), "jane_smith", "jane@example.com", "password456", "Female",
                java.sql.Date.valueOf(LocalDate.of(1992, 2, 2)), 32, "Bogor"));
        personList.add(new Person(UUID.randomUUID().toString(), "mike_johnson", "mike@example.com", "password789", "Male",
                java.sql.Date.valueOf(LocalDate.of(1988, 3, 3)), 36, "Depok"));
        personList.add(new Person(UUID.randomUUID().toString(), "sara_connor", "sara@example.com", "password000", "Female",
                java.sql.Date.valueOf(LocalDate.of(1995, 4, 4)), 29, "Tangerang"));
        personList.add(new Person(UUID.randomUUID().toString(), "alex_brown", "alex@example.com", "password111", "Non-binary",
                java.sql.Date.valueOf(LocalDate.of(1993, 5, 5)), 31, "Bekasi"));
        personList.add(new Person(UUID.randomUUID().toString(), "lisa_wilson", "lisa@example.com", "password222", "Female",
                java.sql.Date.valueOf(LocalDate.of(1985, 6, 6)), 39, "Jakarta"));
        personList.add(new Person(UUID.randomUUID().toString(), "kevin_white", "kevin@example.com", "password333", "Male",
                java.sql.Date.valueOf(LocalDate.of(1991, 7, 7)), 33, "Bogor"));
        personList.add(new Person(UUID.randomUUID().toString(), "nina_green", "nina@example.com", "password444", "Female",
                java.sql.Date.valueOf(LocalDate.of(1987, 8, 8)), 37, "Depok"));
        personList.add(new Person(UUID.randomUUID().toString(), "chris_black", "chris@example.com", "password555", "Male",
                java.sql.Date.valueOf(LocalDate.of(1994, 9, 9)), 30, "Tangerang"));
        personList.add(new Person(UUID.randomUUID().toString(), "diana_red", "diana@example.com", "password666", "Female",
                java.sql.Date.valueOf(LocalDate.of(1996, 10, 10)), 28, "Bekasi"));
        personList.add(new Person(UUID.randomUUID().toString(), "tom_hanks", "tom@example.com", "password777", "Male",
                java.sql.Date.valueOf(LocalDate.of(1980, 11, 11)), 43, "Jakarta"));
        personList.add(new Person(UUID.randomUUID().toString(), "cathy_james", "cathy@example.com", "password888", "Female",
                java.sql.Date.valueOf(LocalDate.of(1993, 12, 12)), 30, "Bogor"));
    }

    public List<Person> findAll(){
        return personList;
    }

    public void add(Person person) {
        personList.add(person);
    }
}
