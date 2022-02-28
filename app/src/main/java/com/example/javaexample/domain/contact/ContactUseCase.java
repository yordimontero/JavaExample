package com.example.javaexample.domain.contact;

import android.content.Context;

import com.example.javaexample.core.RetrofitSuccessListener;
import com.example.javaexample.core.VolleySuccessListener;
import com.example.javaexample.data.model.Contact;
import java.util.List;

public interface ContactUseCase {
    void setDataSourceInterface(VolleySuccessListener listener);
    List<Contact> getContactsList(Context context);
}
