package com.heukwu.lunch_divider.service;

import com.heukwu.lunch_divider.model.Person;

import java.util.List;

public interface LunchDivideService {
    List<Person> getPeopleList();
    void addPerson(String name);
    void deletePerson(Long id);
    void checkPerson(Long id);
    void unCheckPerson(Long id);
    List<List<String>> divideIntoGroup(int groupCount);
}
