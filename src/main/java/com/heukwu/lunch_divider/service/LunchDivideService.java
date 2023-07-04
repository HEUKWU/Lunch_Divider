package com.heukwu.lunch_divider.service;

import com.heukwu.lunch_divider.model.Person;

import java.util.List;

public interface LunchDivideService {
    List<Person> getPeopleList();
    void deletePerson(Long id);
    void addPerson(String name);
    List<List<String>> divideIntoGroup(int groupCount);
}
