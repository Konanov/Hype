package com.person.entity;

/**
 * Created by user01 on 3/10/17.
 */
public class Person {

    public Person(String name, String surname, Type type) {
        this.name = name;
        this.surname = surname;
        this.type = type;
    }

    private String id;
    private String name;
    private String surname;
    private Type type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public enum Type {
        SELEBRITY, REGULAR, POPULAR, GODLIKE;
    }
}
