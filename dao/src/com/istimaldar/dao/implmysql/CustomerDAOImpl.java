package com.istimaldar.dao.implmysql;

import com.istimaldar.dao.connectionpool.ConnectionPool;
import com.istimaldar.dao.daointerface.CustomerDAO;
import com.istimaldar.dao.entity.Customer;
import com.istimaldar.dao.entity.Order;
import com.istimaldar.dao.sqlconstants.CustomerTable;
import com.istimaldar.dao.sqlconstants.OrderTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(CustomerTable.CREATE)
        ) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            int rows = statement.executeUpdate();
            if (rows == 0) {
                throw new SQLException();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer readCustomerById(int id) {
        Customer result = null;
        List<Order> order = new LinkedList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(CustomerTable.READ)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int bookID = resultSet.getInt(OrderTable.BOOK_ID);
                    if (resultSet.wasNull()) {
                        order.add(new Order(resultSet.getInt(CustomerTable.ORDER_ID),
                                resultSet.getBoolean(OrderTable.SUBCRIPTION),
                                resultSet.getDate(OrderTable.BEGINNING), resultSet.getDate(OrderTable.ENDING),
                                resultSet.getBoolean(OrderTable.CLOSED), resultSet.getDate(OrderTable.CLOSE_DATE),
                                BookDAOImpl.getInstance().readBookById(bookID),
                                resultSet.getInt(OrderTable.CUSTOMER_ID)));
                    }
                    result = new Customer(resultSet.getInt(CustomerTable.ID),
                            resultSet.getString(CustomerTable.FIRST_NAME), resultSet.getString(CustomerTable.LAST_NAME),
                            order);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(CustomerTable.UPDATE)
        ) {
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            return statement.executeUpdate() != 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteCustomerById(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(CustomerTable.DELETE)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }
}
