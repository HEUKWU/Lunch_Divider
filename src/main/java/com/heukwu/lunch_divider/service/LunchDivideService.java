package com.heukwu.lunch_divider.service;

import com.heukwu.lunch_divider.model.Person;

import java.util.List;

public interface LunchDivideService {
    List<Person> getPeopleList(List<String> names);
    String divideIntoGroup(List<Person> people, int groupCount);
}
