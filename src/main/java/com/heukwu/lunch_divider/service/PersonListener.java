package com.heukwu.lunch_divider.service;

import com.heukwu.lunch_divider.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class PersonListener extends AbstractMongoEventListener<Person> {

    private final SequenceGeneratorService generatorService;

    @Autowired
    public PersonListener(SequenceGeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Person> event) {
        event.getSource().setId(generatorService.generateSequence(Person.SEQUENCE_NAME));
    }
}
