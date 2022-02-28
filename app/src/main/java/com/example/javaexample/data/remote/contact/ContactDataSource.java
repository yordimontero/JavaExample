package com.example.javaexample.data.remote.contact;

import android.content.Context;

import com.example.javaexample.core.RetrofitSuccessListener;
import com.example.javaexample.core.VolleySuccessListener;
import com.example.javaexample.data.model.Contact;

import java.util.List;

public interface ContactDataSource {
    void setInterface(VolleySuccessListener listener);
    List<Contact> getContactsList(Context context);
}
