package com.netcracker.istimaldar.dao.daointerface;

import com.netcracker.istimaldar.dao.beans.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public interface CustomerDAO {
    void createCustomer(Customer customer) throws SQLException;
    Customer readCustomerById(int id);
    boolean updateCustomer(Customer customer);
    void deleteCustomerById(int id);
    List<Customer> getAll();
}
