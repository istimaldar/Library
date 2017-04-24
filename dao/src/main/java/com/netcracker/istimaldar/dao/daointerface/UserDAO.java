package com.netcracker.istimaldar.dao.daointerface;

import com.netcracker.istimaldar.dao.beans.User;

import java.util.List;

/**
 * Created by istimaldar
 */
public interface UserDAO {
    void createCustomer(User user);
    User readCustomerById(int id);
    boolean updateCustomer(User user);
    void deleteCustomerById(int id);
    List<User> getAll();
}
