package com.istimaldar.dao.factory;

import com.istimaldar.dao.daointerface.AuthorDAO;
import com.istimaldar.dao.daointerface.BookDAO;
import com.istimaldar.dao.daointerface.CustomerDAO;

/**
 * Created by istimaldar
 */
interface DAOFactory {
    AuthorDAO getAuthorDAO();
    BookDAO getBookDAO();
    CustomerDAO getCustomerDAO();
}
