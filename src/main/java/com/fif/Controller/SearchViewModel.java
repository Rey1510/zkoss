package com.fif.Controller;

import com.fif.Entity.Log;
import com.fif.Entity.Person;
import com.fif.services.PersonService;
import com.fif.services.impl.PersonServiceImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.*;

import java.time.LocalDate;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SearchViewModel{

    @WireVariable
    private PersonService personService;
    private Long id;
    private String username;
    private String email;
    private String password;
    private String gender;
    private java.util.Date birthday;
    private int age;
    private String jabodetabek;
    private String keyword;

    private List<Person> personList;
    private Person selectedPerson;

    @Init
    public void init() {
        keyword="";
        personList = new ListModelList<>();
//        personService.addPerson(new Person( "john_doe", "john@example.com", "password123", "Male",
//                java.sql.Date.valueOf(LocalDate.of(1990, 1, 1)), 34, "Jakarta"));
//        personService.addPerson(new Person( "jane_smith", "jane@example.com", "password456", "Female",
//                java.sql.Date.valueOf(LocalDate.of(1992, 2, 2)), 32, "Bogor"));
//        personService.addPerson(new Person( "mike_johnson", "mike@example.com", "password789", "Male",
//                java.sql.Date.valueOf(LocalDate.of(1988, 3, 3)), 36, "Depok"));
//        personService.addPerson(new Person( "sara_connor", "sara@example.com", "password000", "Female",
//                java.sql.Date.valueOf(LocalDate.of(1995, 4, 4)), 29, "Tangerang"));
//        personService.addPerson(new Person( "alex_brown", "alex@example.com", "password111", "Non-binary",
//                java.sql.Date.valueOf(LocalDate.of(1993, 5, 5)), 31, "Bekasi"));
//        personService.addPerson(new Person( "lisa_wilson", "lisa@example.com", "password222", "Female",
//                java.sql.Date.valueOf(LocalDate.of(1985, 6, 6)), 39, "Jakarta"));
//        personService.addPerson(new Person( "kevin_white", "kevin@example.com", "password333", "Male",
//                java.sql.Date.valueOf(LocalDate.of(1991, 7, 7)), 33, "Bogor"));
//        personService.addPerson(new Person( "nina_green", "nina@example.com", "password444", "Female",
//                java.sql.Date.valueOf(LocalDate.of(1987, 8, 8)), 37, "Depok"));
//        personService.addPerson(new Person( "chris_black", "chris@example.com", "password555", "Male",
//                java.sql.Date.valueOf(LocalDate.of(1994, 9, 9)), 30, "Tangerang"));
//        personService.addPerson(new Person( "diana_red", "diana@example.com", "password666", "Female",
//                java.sql.Date.valueOf(LocalDate.of(1996, 10, 10)), 28, "Bekasi"));
//        personService.addPerson(new Person( "tom_hanks", "tom@example.com", "password777", "Male",
//                java.sql.Date.valueOf(LocalDate.of(1980, 11, 11)), 43, "Jakarta"));
//        personService.addPerson(new Person( "cathy_james", "cathy@example.com", "password888", "Female",
//                java.sql.Date.valueOf(LocalDate.of(1993, 12, 12)), 30, "Bogor"));
        personList.addAll(personService.getPerson());
    }

//    private void loadAllData() {
//        personList.addAll(personService.findAll());
//    }

    @Command
    @NotifyChange("personList")
    public void search() {
        selectedPerson = null;
        personList.clear();
        personList.addAll(personService.searchPersonsByKeyword(keyword));
    }

    @Command
    @NotifyChange("personList")
    public void delete() {
        if(selectedPerson == null) throw new RuntimeException("Please select a person before deleting");
        personService.deletePerson(selectedPerson);

        personList.clear();
        personList.addAll(personService.getPerson());

        System.out.println("Deleted Person: " + selectedPerson.getUsername());
        selectedPerson = null;
    }

    @Command
    @NotifyChange("personList")
    public void addUser() {
        personService.addPerson(new Person(username,email,password, gender, birthday, age, jabodetabek));
        System.out.println(username);
        System.out.println(email);
        System.out.println(gender);
        System.out.println(birthday);
        System.out.println(age);
        System.out.println(jabodetabek);
        search();
    }

    @Command
    @NotifyChange("personList")
    public void update() {
        if (selectedPerson == null) throw new RuntimeException("Please select a person before updating");

        // Use selectedPerson's updated fields for the update operation
        personService.update(selectedPerson, selectedPerson.getUsername(), selectedPerson.getEmail(),
                selectedPerson.getGender(), selectedPerson.getBirthday(), selectedPerson.getAge(),
                selectedPerson.getJabodetabek());

        // Refresh the list after updating
        personList.clear();
        personList.addAll(personService.getPerson());

        System.out.println("Updated Person: " + selectedPerson.getUsername());
    }


//    @Command
//    @NotifyChange("personList")
//    public void updateUser() {
//        if (selectedPerson == null) throw new RuntimeException("Please select a person before updating");
//
//        // Use selectedPerson's fields for update instead of this.username, etc.
//        personService.update(
//                selectedPerson.getUsername(),
//                selectedPerson.getEmail(),
//                selectedPerson.getGender(),
//                selectedPerson.getBirthday(),
//                selectedPerson.getAge(),
//                selectedPerson.getJabodetabek()
//        );
//
//        // Refresh the list after updating
//        personList.clear();
//        personList.addAll(personService.getPerson());
//
//        System.out.println("Updated Person: " + selectedPerson.getUsername());
//        selectedPerson = null;
//    }



    public void setKeyword(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword(){
        return keyword;
    }

    public List<Person> getPersonList(){
        return personList;
    }

    public void setSelectedPerson(Person selectedPerson){
        this.selectedPerson = selectedPerson;
    }

    public Person getSelectedPerson(){
        return selectedPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJabodetabek() {
        return jabodetabek;
    }

    public void setJabodetabek(String jabodetabek) {
        this.jabodetabek = jabodetabek;
    }
}
