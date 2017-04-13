package com.istimaldar.dao.implmysql;

import com.istimaldar.dao.daointerface.OrderDAO;
import com.istimaldar.dao.entity.Order;

import java.util.List;

/**
 * Created by istimaldar
 */
public class OrderDAOImpl implements OrderDAO {
    private static class OrderSingletonHolder {
        static final OrderDAOImpl instance = new OrderDAOImpl();
    }

    public static OrderDAO getInstance() {
        return OrderSingletonHolder.instance;
    }
    
    @Override
    public void createOrder(Order customer) {
        
    }

    @Override
    public Order readOrderById(int id) {
        return null;
    }

    @Override
    public void updateOrder(Order customer) {

    }

    @Override
    public void deleteOrderById(int id) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
