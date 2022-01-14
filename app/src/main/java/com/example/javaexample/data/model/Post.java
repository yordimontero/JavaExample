package com.example.javaexample.data.model;

public class Post {
    /*
        Objecto Post.
        Esto es equivalente en Kotlin a:
        data class Post(
            val userId: Int,
            val id: Int,
            val title: String,
            val body: String
        )
    */
    private int userId;
    private int id;
    private String title;
    public String body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
