package com.netcracker.istimaldar.dao.impl.mysql;

import com.netcracker.istimaldar.dao.connectionpool.ConnectionPool;
import com.netcracker.istimaldar.dao.beans.Book;
import com.netcracker.istimaldar.dao.sqlconstants.AuthorTable;
import com.netcracker.istimaldar.dao.sqlconstants.BookGenreTable;
import com.netcracker.istimaldar.dao.sqlconstants.BookTable;
import com.netcracker.istimaldar.dao.daointerface.BookDAO;
import com.netcracker.istimaldar.dao.beans.Author;
import com.netcracker.istimaldar.dao.beans.Genre;
import com.netcracker.istimaldar.dao.sqlconstants.GenreTable;

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
                        genres.push(Genre.newBuilder()
                                        .setId(resultSet.getInt(BookGenreTable.GENRE_ID))
                                        .setGenre(resultSet.getString(GenreTable.GENRE))
                                        .setDescription(resultSet.getString(GenreTable.DESCRIPTION))
                                        .build()
                                );
                    }
                    if (resultSet.previous()) {
                        result = Book.newBuilder()
                                .setId(resultSet.getInt(BookTable.ID))
                                .setName(resultSet.getString(BookTable.NAME))
                                .setLanguage(resultSet.getString(BookTable.LANGUAGE))
                                .setAuthor(Author.newBuilder()
                                        .setId(resultSet.getInt(BookTable.AUTHOR_ID))
                                        .setFirstName(resultSet.getString(AuthorTable.FIRST_NAME))
                                        .setLastName(resultSet.getString(AuthorTable.LAST_NAME))
                                        .setDescription(resultSet.getString(AuthorTable.DESCRIPTION))
                                        .build())
                                .setGenres(genres)
                                .build();
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
