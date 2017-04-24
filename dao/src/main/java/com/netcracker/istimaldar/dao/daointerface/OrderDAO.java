package com.netcracker.istimaldar.dao.daointerface;

import com.netcracker.istimaldar.dao.beans.Order;

import java.util.List;

/**
 * Created by istimaldar
 */
public interface OrderDAO {
    void createOrder(Order order);
    Order readOrderById(int id);
    boolean updateOrder(Order order);
    void deleteOrderById(int id);
    List<Order> getAll();
}
