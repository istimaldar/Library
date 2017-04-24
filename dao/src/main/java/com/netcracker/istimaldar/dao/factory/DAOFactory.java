package com.netcracker.istimaldar.dao.factory;

import com.netcracker.istimaldar.dao.daointerface.*;

/**
 * Created by istimaldar
 */
public interface DAOFactory {
    AuthorDAO getAuthorDAO();
    BookDAO getBookDAO();
    CustomerDAO getCustomerDAO();
    GenreDAO getGenreDAO();
    OrderDAO getOrderDAO();
}
