package com.istimaldar.dao.daointerface;

import com.istimaldar.dao.entity.Customer;

import java.util.List;

/**
 * Created by istimaldar
 */
public interface CustomerDAO {
    void createCustomer(Customer Customer);
    Customer readCustomerById(int id);
    void updateCustomer(Customer Customer);
    void deleteCustomerById(int id);
    List<Customer> getAll();
}
