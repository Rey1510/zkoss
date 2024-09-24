package com.fif.Controller;

import com.fif.Entity.Person;
import com.fif.services.PersonService;
import com.fif.services.PersonServiceImpl;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import java.util.Set;

public class SearchController extends SelectorComposer<Component> {

//    private static final long serialVersionUID = 1L;
    @Wire
    private Textbox keywordBox;

    @Wire
    private Listbox personList;

    @Wire
    private Label birthdayLabel;

    @Wire
    private Label ageLabel;

    @Wire
    private Label addressLabel;

    private ListModelList<Person> dataUsername = new ListModelList<>();

    private PersonService personService = new PersonServiceImpl();

    public SearchController(){
        dataUsername.addAll(personService.findAll());
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        personList.setModel(dataUsername);
    }

    @Listen("onClick = #searchButton; onOK = window")
    public void search() {
        String keyword = keywordBox.getValue();
        dataUsername.clear();
        dataUsername.addAll(personService.search(keyword));
    }

    @Listen("onSelect = #personList")
    public void showDetail(){
        Set<Person> selection = dataUsername.getSelection();
        Person selected = selection.iterator().next();
        birthdayLabel.setValue(selected.getBirthday());
        ageLabel.setValue(String.valueOf(selected.getAge()));
        addressLabel.setValue(selected.getJabodetabek());
    }
}
