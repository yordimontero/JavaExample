package com.example.javaexample.domain.person;

import com.example.javaexample.data.model.Person;

import java.util.List;

public interface PersonUseCase {
    List<Person> getPersonList();
}
