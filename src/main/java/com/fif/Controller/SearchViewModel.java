package com.fif.Controller;

import com.fif.Entity.Person;
import com.fif.services.PersonService;
import com.fif.services.PersonServiceImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SearchViewModel{

    private int id;
    private String username;
    private String email;
    private String password;
    private String gender;
    private java.util.Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    private int age;
    private String jabodetabek;


    private String keyword;

    private List<Person> personList = new ListModelList<Person>();

    private Person selectedPerson;

    private PersonService personService = new PersonServiceImpl();

    public SearchViewModel() {
        loadAllData();
    }

    private void loadAllData() {
        personList.addAll(personService.findAll());
    }

    @Command
    @NotifyChange("personList")
    public void search() {
        selectedPerson = null;
        personList.clear();
        personList.addAll(personService.search(keyword));
    }

    @Command
    @NotifyChange("personList")
    public void delete() {
        if(selectedPerson == null) throw new RuntimeException("Please select a person before deleting");
        personService.delete(selectedPerson.getId());

        personList.clear();
        personList.addAll(personService.findAll());

        System.out.println("Deleted Person: " + selectedPerson.getUsername());
        selectedPerson = null;
    }

    @Command
    @NotifyChange("personList")
    public void addUser() {
        personService.add(this.username,this.email,this.password,this.gender, this.birthday,this.age,this.jabodetabek);
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
    public void updateUser() {
        if (selectedPerson == null) throw new RuntimeException("Please select a person before updating");

        // Use selectedPerson's fields for update instead of this.username, etc.
        personService.update(
                selectedPerson.getId(),
                selectedPerson.getUsername(),
                selectedPerson.getEmail(),
                selectedPerson.getGender(),
                selectedPerson.getBirthday(),
                selectedPerson.getAge(),
                selectedPerson.getJabodetabek()
        );

        // Refresh the list after updating
        personList.clear();
        personList.addAll(personService.findAll());

        System.out.println("Updated Person: " + selectedPerson.getUsername());
        selectedPerson = null;
    }



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
}
