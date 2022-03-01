package com.example.javaexample.presentation.contact;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.javaexample.core.RetrofitSuccessListener;
import com.example.javaexample.core.VolleySuccessListener;
import com.example.javaexample.data.model.Contact;
import com.example.javaexample.domain.contact.ContactUseCase;

import java.util.List;

public class ContactViewModel extends ViewModel implements VolleySuccessListener {

    ContactUseCase useCase;
    MutableLiveData<List<Contact>> mutableContactList;
    MutableLiveData<String> errorMessage;
    VolleySuccessListener listener;

    public ContactViewModel(ContactUseCase useCase) {
        this.useCase = useCase;
        mutableContactList = new MutableLiveData<>();
        errorMessage = new MutableLiveData<>();
        setInterface();
        setUseCaseInterface();
    }

    public void setInterface() {
        this.listener = this;
    }

    public void setUseCaseInterface() {
        useCase.setDataSourceInterface(this);
    }

    public MutableLiveData<List<Contact>> getContactsList(Context context) {

        mutableContactList.setValue(
                useCase.getContactsList(context)
        );

        return mutableContactList;
    }

    @Override
    public <T> void onVolleyResult(List<T> data) {

        mutableContactList.setValue(
                (List<Contact>) data
        );

    }

}
