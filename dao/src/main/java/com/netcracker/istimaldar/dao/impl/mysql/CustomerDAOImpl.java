package com.netcracker.istimaldar.dao.impl.mysql;

import com.netcracker.istimaldar.dao.daointerface.CustomerDAO;
import com.netcracker.istimaldar.dao.beans.Order;
import com.netcracker.istimaldar.dao.connectionpool.ConnectionPool;
import com.netcracker.istimaldar.dao.beans.Customer;
import com.netcracker.istimaldar.dao.sqlconstants.CustomerTable;
import com.netcracker.istimaldar.dao.sqlconstants.OrderTable;

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
                        order.add(Order.newBuilder()
                                .setId(resultSet.getInt(CustomerTable.ORDER_ID))
                                .setSubscription(resultSet.getBoolean(OrderTable.SUBCRIPTION))
                                .setBeginning(resultSet.getDate(OrderTable.BEGINNING))
                                .setEnding(resultSet.getDate(OrderTable.ENDING))
                                .setClosed(resultSet.getBoolean(OrderTable.CLOSED))
                                .setCloseDate(resultSet.getDate(OrderTable.CLOSE_DATE))
                                .setBook(BookDAOImpl.getInstance().readBookById(bookID))
                                .setCustomerID(resultSet.getInt(OrderTable.CUSTOMER_ID))
                                .build());
                    }
                    result = Customer.newBuilder()
                            .setId(resultSet.getInt(CustomerTable.ID))
                            .setFirstName(resultSet.getString(CustomerTable.FIRST_NAME))
                            .setLastName(resultSet.getString(CustomerTable.LAST_NAME))
                            .setOrders(order)
                            .build();
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
