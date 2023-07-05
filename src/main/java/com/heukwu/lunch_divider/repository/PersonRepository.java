package com.heukwu.lunch_divider.repository;

import com.heukwu.lunch_divider.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<Person, Long> {
    Optional<Person> findPersonByName(String name);
    List<Person> findByIsCheckedIsTrue();
}
