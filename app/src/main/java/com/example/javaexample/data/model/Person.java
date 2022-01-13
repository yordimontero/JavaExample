package com.example.javaexample.data.model;

public class Person {
    /*
        Objecto Person.
        Esto es equivalente en Kotlin a:
        data class Person(
            val name: String,
            val age: Int
        )
    */
    String name;
    int age;

    public Person(String name, int age) {
        /*
            Constructor del Objecto Person.
        */
        this.name = name;
        this.age = age;
    }

    /*
         Nota: a diferencia de Kotlin, en Java se deben crear los Getters y Setters en
         los Objectos.
    */
    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
