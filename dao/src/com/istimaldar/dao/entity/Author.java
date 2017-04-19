package com.istimaldar.dao.entity;

import java.io.Serializable;

/**
 * Created by istimaldar
 */
public class Author implements Serializable{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id == author.id && firstName.equals(author.firstName) && lastName.equals(author.lastName)
                && description.equals(author.description);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
