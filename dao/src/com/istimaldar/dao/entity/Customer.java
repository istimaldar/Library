package com.istimaldar.dao.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by istimaldar
 */
public class Customer implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id == customer.id && firstName.equals(customer.firstName) && lastName.equals(customer.lastName)
                && orders.equals(customer.orders);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + orders.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
