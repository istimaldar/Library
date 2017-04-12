package com.istimaldar.dao.daointerface;

import com.istimaldar.dao.entity.Book;

import java.util.List;

/**
 * Created by istimaldar
 */
public interface BookDAO {
    void createBook(Book book);
    Book readBookById(int id);
    void updateBook(Book book);
    void deleteBookById(int id);
    List<Book> getAll();
}
