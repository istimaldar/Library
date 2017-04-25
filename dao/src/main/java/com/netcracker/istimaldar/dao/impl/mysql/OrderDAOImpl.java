package com.netcracker.istimaldar.dao.impl.mysql;

import com.netcracker.istimaldar.dao.connectionpool.ConnectionPool;
import com.netcracker.istimaldar.dao.daointerface.OrderDAO;
import com.netcracker.istimaldar.dao.beans.Order;
import com.netcracker.istimaldar.dao.sqlconstants.OrderTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public class OrderDAOImpl implements OrderDAO {
    private static class OrderSingletonHolder {
        static final OrderDAOImpl INSTANCE = new OrderDAOImpl();
    }

    public static OrderDAO getInstance() {
        return OrderSingletonHolder.INSTANCE;
    }
    
    @Override
    public void createOrder(Order order) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(OrderTable.CREATE)
        ) {
            statement.setBoolean(1, order.isSubscription());
            statement.setDate(2, new java.sql.Date(order.getBeginning().getTime()));
            statement.setDate(3, new java.sql.Date(order.getEnding().getTime()));
            statement.setBoolean(4, order.isClosed());
            statement.setDate(5, new java.sql.Date(order.getCloseDate().getTime()));
            statement.setInt(6, order.getBook().getId());
            statement.setInt(7, order.getCustomerID());
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
    public Order readOrderById(int id) {
        Order result = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(OrderTable.READ)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = Order.newBuilder()
                            .setId(resultSet.getInt(OrderTable.ID))
                            .setSubscription(resultSet.getBoolean(OrderTable.SUBCRIPTION))
                            .setBeginning(resultSet.getDate(OrderTable.BEGINNING))
                            .setEnding(resultSet.getDate(OrderTable.ENDING))
                            .setClosed(resultSet.getBoolean(OrderTable.CLOSED))
                            .setCloseDate(resultSet.getDate(OrderTable.CLOSE_DATE))
                            .setBook(BookDAOImpl.getInstance().readBookById(resultSet.getInt(OrderTable.BOOK_ID)))
                            .setCustomerID(resultSet.getInt(OrderTable.CUSTOMER_ID))
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
    public boolean updateOrder(Order order) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(OrderTable.UPDATE)
        ) {
            statement.setInt(1, order.getId());
            statement.setBoolean(2, order.isSubscription());
            statement.setDate(3, new java.sql.Date(order.getBeginning().getTime()));
            statement.setDate(4, new java.sql.Date(order.getEnding().getTime()));
            statement.setBoolean(5, order.isClosed());
            statement.setDate(6, new java.sql.Date(order.getCloseDate().getTime()));
            statement.setInt(7, order.getBook().getId());
            statement.setInt(8, order.getCustomerID());
            return statement.executeUpdate() != 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteOrderById(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(OrderTable.DELETE)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
