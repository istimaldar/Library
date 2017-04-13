package com.istimaldar.dao.implmysql;

import com.istimaldar.dao.daointerface.BookDAO;
import com.istimaldar.dao.entity.Book;

import java.util.List;

/**
 * Created by istimaldar
 */
public class BookDAOImpl implements BookDAO {
    private static class BookSingletonHolder {
        static final BookDAOImpl INSTANCE = new BookDAOImpl();
    }

    public static BookDAOImpl getInstance() {
        return BookSingletonHolder.INSTANCE;
    }

    @Override
    public void createBook(Book book) {

    }

    @Override
    public Book readBookById(int id) {
        return null;
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBookById(int id) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
