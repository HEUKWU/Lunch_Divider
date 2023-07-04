package com.heukwu.lunch_divider.service;

import com.heukwu.lunch_divider.model.Person;
import com.heukwu.lunch_divider.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LunchDivideServiceImpl implements LunchDivideService {

    private final PersonRepository personRepository;

    @Autowired
    public LunchDivideServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPeopleList() {
        return personRepository.findAll();
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void addPerson(String name) {
        if (name.equals("")) {
            throw new IllegalStateException("이름을 입력해주세요.");
        }
        if (personRepository.findPersonByName(name).isPresent()) {
            throw new IllegalStateException("중복된 이름이 존재합니다.");
        }
        personRepository.save(new Person(name));
    }

    @Override
    public List<List<String>> divideIntoGroup(int groupCount) {
        List<Person> people = personRepository.findAll();
        if (groupCount > people.size()) {
            throw new IllegalStateException("유효한 개수를 입력하세요.");
        }
        Collections.shuffle(people);

        int groupSize = people.size() / groupCount;
        int remain = people.size() % groupCount;

        List<List<String>> peopleList = new ArrayList<>();

        for (int i = 0, k = 0; i < groupCount; i++) {
            int count = groupSize;
            if (i < remain) {
                count++;
            }
            List<String> name = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                name.add(people.get(k + j).getName());
            }
            peopleList.add(name);
            k += count;
        }

        return peopleList;
    }
}
