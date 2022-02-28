package com.example.javaexample.core;

import java.util.List;

public interface VolleySuccessListener {
    //<T> void onVolleyResult(Boolean isSuccess, T data);
    <T> void onVolleyResult(Boolean isSuccess, List<T> data);
}
