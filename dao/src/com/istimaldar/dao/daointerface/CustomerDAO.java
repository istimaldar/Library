package com.istimaldar.dao.daointerface;

import com.istimaldar.dao.entity.Customer;

import java.util.List;

/**
 * Created by istimaldar
 */
public interface CustomerDAO {
    void createCustomer(Customer customer);
    Customer readCustomerById(int id);
    void updateCustomer(Customer customer);
    void deleteCustomerById(int id);
    List<Customer> getAll();
}
