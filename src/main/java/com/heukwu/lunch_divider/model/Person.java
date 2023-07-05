package com.heukwu.lunch_divider.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "people")
public class Person {

    @Transient
    public static final String SEQUENCE_NAME = "sequence";

    @Id
    private Long id;

    private String name;

    private Boolean isChecked = true;

    public Person() {
    }

    public Person(String name, boolean isChecked) {
        this.name = name;
        this.isChecked = isChecked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked() {
        isChecked = !isChecked;
    }
}
