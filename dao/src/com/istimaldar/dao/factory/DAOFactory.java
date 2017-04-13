package com.istimaldar.dao.factory;

import com.istimaldar.dao.daointerface.*;

/**
 * Created by istimaldar
 */
interface DAOFactory {
    AuthorDAO getAuthorDAO();
    BookDAO getBookDAO();
    CustomerDAO getCustomerDAO();
    GenreDAO getGenreDAO();
    OrderDAO getOrderDAO();
}
