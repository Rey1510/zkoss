package com.fif.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fif.Entity.Person;

public class PersonRepository {

    public static List<Person> personList = new ArrayList<Person>();

    private static int id = 1;

    static {
        personList.add(new Person(id++, "john_doe", "john@example.com", "password123", "Male",
                Date.valueOf(LocalDate.of(1990, 1, 1)), 34, "Jakarta"));
        personList.add(new Person(id++, "jane_smith", "jane@example.com", "password456", "Female",
                Date.valueOf(LocalDate.of(1992, 2, 2)), 32, "Bogor"));
        personList.add(new Person(id++, "mike_johnson", "mike@example.com", "password789", "Male",
                Date.valueOf(LocalDate.of(1988, 3, 3)), 36, "Depok"));
        personList.add(new Person(id++, "sara_connor", "sara@example.com", "password000", "Female",
                Date.valueOf(LocalDate.of(1995, 4, 4)), 29, "Tangerang"));
        personList.add(new Person(id++, "alex_brown", "alex@example.com", "password111", "Non-binary",
                Date.valueOf(LocalDate.of(1993, 5, 5)), 31, "Bekasi"));
        personList.add(new Person(id++, "lisa_wilson", "lisa@example.com", "password222", "Female",
                Date.valueOf(LocalDate.of(1985, 6, 6)), 39, "Jakarta"));
        personList.add(new Person(id++, "kevin_white", "kevin@example.com", "password333", "Male",
                Date.valueOf(LocalDate.of(1991, 7, 7)), 33, "Bogor"));
        personList.add(new Person(id++, "nina_green", "nina@example.com", "password444", "Female",
                Date.valueOf(LocalDate.of(1987, 8, 8)), 37, "Depok"));
        personList.add(new Person(id++, "chris_black", "chris@example.com", "password555", "Male",
                Date.valueOf(LocalDate.of(1994, 9, 9)), 30, "Tangerang"));
        personList.add(new Person(id++, "diana_red", "diana@example.com", "password666", "Female",
                Date.valueOf(LocalDate.of(1996, 10, 10)), 28, "Bekasi"));
        personList.add(new Person(id++, "tom_hanks", "tom@example.com", "password777", "Male",
                Date.valueOf(LocalDate.of(1980, 11, 11)), 43, "Jakarta"));
        personList.add(new Person(id++, "cathy_james", "cathy@example.com", "password888", "Female",
                Date.valueOf(LocalDate.of(1993, 12, 12)), 30, "Bogor"));
    }

    public List<Person> findAll(){
        return personList;
    }

    public void add(Person person) {
        personList.add(person);
    }
}
