package com.example.javaexample.core.uiutils.text;

import com.example.javaexample.data.model.ResponseError;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class TextUtils {

    public String parseJsonToString(String errorMessage) {
        /*
            Método encargado de parsear un errorBody de Retrofit en una String.
        */
        JsonElement errorMsg = JsonParser.parseString(errorMessage);
        return new Gson().fromJson(errorMsg, ResponseError.class).getError();
    }

}
