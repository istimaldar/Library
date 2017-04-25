package com.netcracker.istimaldar.dao.factory;

import com.netcracker.istimaldar.dao.daointerface.*;
import com.netcracker.istimaldar.dao.impl.mysql.*;

/**
 * Created by istimaldar
 */
public class MySqlDAOFactory implements DAOFactory {
    private static class MySqlDAOFactorySingletonHolder {
        static final MySqlDAOFactory INSTANCE = new MySqlDAOFactory();
    }

    @Override
    public AuthorDAO getAuthorDAO() {
        return AuthorDAOImpl.getInstance();
    }

    @Override
    public BookDAO getBookDAO() {
        return BookDAOImpl.getInstance();
    }

    @Override
    public CustomerDAO getCustomerDAO() {
        return CustomerDAOImpl.getInstance();
    }

    @Override
    public GenreDAO getGenreDAO() {
        return GenreDAOImpl.getInstance();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return OrderDAOImpl.getInstance();
    }

    @Override
    public UserDAO getUserDAO() {
        return UserDAOImpl.getInstance();
    }

    public static DAOFactory getInstance() {
        return MySqlDAOFactorySingletonHolder.INSTANCE;
    }
}
