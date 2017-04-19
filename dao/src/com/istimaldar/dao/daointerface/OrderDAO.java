package com.istimaldar.dao.daointerface;

import com.istimaldar.dao.entity.Order;

import java.util.List;

/**
 * Created by istimaldar
 */
public interface OrderDAO {
    void createOrder(Order customer);
    Order readOrderById(int id);
    boolean updateOrder(Order customer);
    void deleteOrderById(int id);
    List<Order> getAll();
}
