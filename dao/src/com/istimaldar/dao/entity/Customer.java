package com.istimaldar.dao.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by istimaldar
 */
public class Customer
{
    private int id;
    private String firstName;
    private String lastName;
    private List<Order> orders;

    public Customer(int id, String firstName, String lastName, List<Order> orders)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public Customer(int id, String firstName, String lastName)
    {
        this(id, firstName, lastName, new LinkedList<>());
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

    public List<Order> getOrders() {
        return orders;
    }
}
