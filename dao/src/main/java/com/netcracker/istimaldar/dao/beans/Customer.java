package com.netcracker.istimaldar.dao.beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by istimaldar
 */
public class Customer implements Cloneable, Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private List<Order> orders;

    private Customer() {

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

    public static CustomerBuilder newBuilder() {
        return new Customer().new CustomerBuilder();
    }

    public class CustomerBuilder {
        private CustomerBuilder() {

        }

        public CustomerBuilder setId(int id) {
            Customer.this.id = id;
            return this;
        }

        public CustomerBuilder setFirstName(String firstName) {
            Customer.this.firstName = firstName;
            return this;
        }

        public CustomerBuilder setLastName(String lastName) {
            Customer.this.lastName = lastName;
            return this;
        }

        public CustomerBuilder setOrders(List<Order> orders) {
            Customer.this.orders = orders;
            return this;
        }

        public Customer build() {
            return Customer.this;
        }
    }
}
