package com.example.javaexample.data.remote.contact;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.javaexample.application.AppConstants;
import com.example.javaexample.core.VolleySuccessListener;
import com.example.javaexample.data.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactDataSourceImpl implements ContactDataSource {

    VolleySuccessListener listener;

    public ContactDataSourceImpl() {}

    @Override
    public void setInterface(VolleySuccessListener listener) {
        this.listener = listener;
    }

    @Override
    public List<Contact> getContactsList(Context context) {

        RequestQueue queue = Volley.newRequestQueue(context);

        List<Contact> contactList = new ArrayList<>();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                AppConstants.BASE_CONTACT_URL,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray array = response.getJSONArray("contacts");

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject contactObject = array.getJSONObject(i);
                        String name = contactObject.getString("name");

                        JSONObject phoneObject = array.getJSONObject(i).getJSONObject("phone");
                        String mobile = phoneObject.getString("mobile");
                        String home = phoneObject.getString("home");
                        String office = phoneObject.getString("office");

                        Log.wtf("TAG", "Name: "+name+", mobile: "+mobile+", home: "+home+", office: "+office);

                        contactList.add(
                                new Contact(
                                        name,
                                        mobile,
                                        home,
                                        office
                                )
                        );

                    }

                    listener.onVolleyResult(contactList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onVolleyResult(null);
            }
        });

        queue.add(request);

        return contactList;

    }

}
