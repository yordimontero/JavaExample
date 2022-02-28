package com.example.javaexample.domain.contact;

import android.content.Context;

import com.example.javaexample.core.VolleySuccessListener;
import com.example.javaexample.data.model.Contact;
import com.example.javaexample.data.remote.contact.ContactDataSource;

import java.util.List;

public class ContactUseCaseImpl implements ContactUseCase {

    ContactDataSource dataSource;
    VolleySuccessListener listener;

    public ContactUseCaseImpl(ContactDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setInterface(VolleySuccessListener listener) {
        this.listener = listener;
    }

    @Override
    public void setDataSourceInterface(VolleySuccessListener listener) {
        dataSource.setInterface(listener);
    }

    @Override
    public List<Contact> getContactsList(Context context) {
        return dataSource.getContactsList(context);
    }

}
