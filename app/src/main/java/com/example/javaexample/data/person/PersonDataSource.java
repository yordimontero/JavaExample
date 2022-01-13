package com.example.javaexample.data.person;

import com.example.javaexample.data.model.Person;

import java.util.List;

public interface PersonDataSource {
    List<Person> createPersonList();
}
