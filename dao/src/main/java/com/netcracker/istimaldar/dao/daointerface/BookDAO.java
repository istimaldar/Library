package com.netcracker.istimaldar.dao.daointerface;

import com.netcracker.istimaldar.dao.beans.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public interface BookDAO {
    void createBook(Book book) throws SQLException;
    Book readBookById(int id);
    boolean updateBook(Book book);
    void deleteBookById(int id);
    List<Book> getAll();
}
