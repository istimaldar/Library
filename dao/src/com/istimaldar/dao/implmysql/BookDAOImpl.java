package com.istimaldar.dao.implmysql;

import com.istimaldar.dao.connectionpool.ConnectionPool;
import com.istimaldar.dao.daointerface.BookDAO;
import com.istimaldar.dao.entity.Author;
import com.istimaldar.dao.entity.Book;
import com.istimaldar.dao.entity.Genre;
import com.istimaldar.dao.sqlconstants.AuthorTable;
import com.istimaldar.dao.sqlconstants.BookGenreTable;
import com.istimaldar.dao.sqlconstants.BookTable;
import com.istimaldar.dao.sqlconstants.GenreTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(AuthorTable.CREATE)
        ) {
            statement.setInt(1, book.getAuthor().getId());
            statement.setString(2, book.getName());
            statement.setString(3, book.getLanguage());
            int rows = statement.executeUpdate();
            if (rows == 0) {
                throw new SQLException();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book readBookById(int id) {
        Book result = null;
        LinkedList<Genre> genres = new LinkedList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(BookTable.READ)
        ) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        genres.push(new Genre(resultSet.getInt(BookGenreTable.GENRE_ID),
                                resultSet.getString(GenreTable.GENRE),
                                resultSet.getString(GenreTable.DESCRIPTION)));
                    }
                    if (resultSet.previous()) {
                        result = new Book(resultSet.getInt(BookTable.ID),
                                resultSet.getString(BookTable.NAME),
                                resultSet.getString(BookTable.LANGUAGE),
                                new Author(resultSet.getInt(BookTable.AUTHOR_ID),
                                        resultSet.getString(AuthorTable.FIRST_NAME),
                                        resultSet.getString(AuthorTable.LAST_NAME),
                                        resultSet.getString(AuthorTable.DESCRIPTION)),
                                genres);
                    }
                }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateBook(Book book) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(AuthorTable.UPDATE)
        ) {
            statement.setInt(1, book.getId());
            statement.setInt(2, book.getAuthor().getId());
            statement.setString(3, book.getName());
            statement.setString(4, book.getLanguage());
            return statement.executeUpdate() != 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteBookById(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(AuthorTable.DELETE)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
