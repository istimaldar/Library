package com.istimaldar.dao.implmysql;

import com.istimaldar.dao.daointerface.CustomerDAO;
import com.istimaldar.dao.entity.Customer;

import java.util.List;

/**
 * Created by istimaldar
 */
public class CustomerDAOImpl implements CustomerDAO {
    private static class CustomerSingletonHolder {
        static final CustomerDAOImpl INSTANCE = new CustomerDAOImpl();
    }

    public static CustomerDAO getInstance() {
        return CustomerSingletonHolder.INSTANCE;
    }

    @Override
    public void createCustomer(Customer customer) {

    }

    @Override
    public Customer readCustomerById(int id) {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomerById(int id) {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
