package com.example.javaexample.presentation.person;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.javaexample.data.model.Person;
import com.example.javaexample.domain.person.PersonUseCase;

import java.util.List;

public class PersonViewModel extends ViewModel {
    /*
        PersonViewModel.
        Esto es equivalente en Kotlin a:
        class PersonViewModel(
            private val useCase: PersonUseCase
        ): ViewModel()
    */

    PersonUseCase useCase;
    /*
        Nota: LiveData<> solamente permite lectura.
              MutableLiveData<> permite lectura y escritura.
    */
    MutableLiveData<List<Person>> personList;

    public PersonViewModel(PersonUseCase useCase) {
        /*
            Constructor del ViewModel.
        */
        this.useCase = useCase;
        personList = new MutableLiveData<>();
    }

    public LiveData<List<Person>> getPersonList() {
        /*
            Método encargado de obtener la lista de personas del UseCase.
        */
        personList.setValue(useCase.getPersonList());
        return personList;
    }

}
