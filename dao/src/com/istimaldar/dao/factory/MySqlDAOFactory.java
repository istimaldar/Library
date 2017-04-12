package com.istimaldar.dao.factory;

import com.istimaldar.dao.daointerface.AuthorDAO;
import com.istimaldar.dao.daointerface.BookDAO;
import com.istimaldar.dao.daointerface.CustomerDAO;
import com.istimaldar.dao.implmysql.AuthorDAOImpl;
import com.istimaldar.dao.implmysql.BookDAOImpl;
import com.istimaldar.dao.implmysql.CustomerDAOImpl;

/**
 * Created by istimaldar
 */
public class MySqlDAOFactory implements DAOFactory {
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
}
