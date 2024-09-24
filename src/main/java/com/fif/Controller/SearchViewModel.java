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

import java.sql.Date;
import java.util.List;
import java.util.Set;

public class SearchViewModel{

    private int id;
    private String username;
    private String email;
    private String password;
    private String gender;
    private java.util.Date birthday;
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
        personService.add(this.id,this.username,this.email,this.password,this.gender, (Date) this.birthday,this.age,this.jabodetabek);
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
