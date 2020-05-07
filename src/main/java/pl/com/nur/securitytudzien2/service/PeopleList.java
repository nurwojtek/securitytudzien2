package pl.com.nur.securitytudzien2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.nur.securitytudzien2.model.People;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleList {

    List<People> peopleList;

    @Autowired
    public PeopleList() {
        peopleList = new ArrayList();
        peopleList.add(new People("Wojtek", "woj123", "ADMIN"));
        peopleList.add(new People("Iza", "iza123", "USER"));
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

}
