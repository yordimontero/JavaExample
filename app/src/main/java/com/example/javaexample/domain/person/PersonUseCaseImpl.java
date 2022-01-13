package com.example.javaexample.domain.person;

import com.example.javaexample.data.model.Person;
import com.example.javaexample.data.person.PersonDataSource;

import java.util.List;

public class PersonUseCaseImpl implements PersonUseCase {
    /*
        PersonUseCase.
        Esto es equivalente en Kotlin a:
        class PersonUseCaseImpl(
            private val dataSource: PersonDataSource
        ): PersonUseCase
    */

    PersonDataSource dataSource;

    public PersonUseCaseImpl(PersonDataSource dataSource) {
        /*
            Constructor del UseCase.
        */
        this.dataSource = dataSource;
    }

    @Override
    public List<Person> getPersonList() {
        /*
            Método encargado de obtener la lista de personas del DataSource.
        */
        return dataSource.createPersonList();
    }
}
