package com.istimaldar.dao.entity;

/**
 * Created by istimaldar
 */
public class Author {
    int id;
    String firstName;
    String lastName;
    String description;

    public Author(int id, String firstName, String lastName, String description)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }
}
