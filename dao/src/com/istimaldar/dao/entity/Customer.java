package com.istimaldar.dao.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by istimaldar
 */
public class Customer
{
    private int id;
    private String firstName;
    private String lastName;
    private List<Book> takenBooks;

    public Customer(int id, String firstName, String lastName, List<Book> takenBooks)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.takenBooks = takenBooks;
    }

    public Customer(int id, String firstName, String lastName)
    {
        this(id, firstName, lastName, new ArrayList<Book>());
    }
}
