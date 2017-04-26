package com.netcracker.istimaldar.dao.daointerface;

import com.netcracker.istimaldar.dao.beans.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public interface OrderDAO {
    void createOrder(Order order) throws SQLException;
    Order readOrderById(int id);
    boolean updateOrder(Order order);
    void deleteOrderById(int id);
    List<Order> getAll();
}
