package com.example.javaexample.data.local.person;

import com.example.javaexample.data.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDataSourceImpl implements PersonDataSource {
    /*
        Esto es equivalente en Kotlin a:
        class PersonDataSourceImpl: PersonDataSource
    */

    @Override
    public List<Person> createPersonList() {
        /*
            Método encargado de crear una lista de personas.
        */
        List<Person> personList;

        personList = new ArrayList<>();

        personList.add(
                new Person("María Rodríguez", 25)
        );
        personList.add(
                new Person("Juan Pérez", 31)
        );
        personList.add(
                new Person("Raúl Sánchez", 22)
        );

        return personList;

    }
}
