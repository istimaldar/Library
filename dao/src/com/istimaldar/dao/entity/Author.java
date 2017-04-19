package com.istimaldar.dao.entity;

/**
 * Created by istimaldar
 */
public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private String description;

    public Author(int id, String firstName, String lastName, String description)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }
}
