package com.netcracker.istimaldar.dao.impl.mysql;

import com.netcracker.istimaldar.dao.connectionpool.ConnectionPool;
import com.netcracker.istimaldar.dao.beans.Author;
import com.netcracker.istimaldar.dao.sqlconstants.AuthorTable;
import com.netcracker.istimaldar.dao.daointerface.AuthorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public class AuthorDAOImpl implements AuthorDAO {
    private static class AuthorSingletonHolder {
        static final AuthorDAOImpl INSTANCE = new AuthorDAOImpl();
    }

    public static AuthorDAO getInstance() {
        return AuthorSingletonHolder.INSTANCE;
    }

    @Override
    public void createAuthor(Author author) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(AuthorTable.CREATE)
        ) {
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.setString(3, author.getDescription());
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
    public Author readAuthorById(int id)  {
        Author result = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(AuthorTable.READ)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = Author.newBuilder()
                            .setId(resultSet.getInt(AuthorTable.ID))
                            .setFirstName(resultSet.getString(AuthorTable.FIRST_NAME))
                            .setLastName(resultSet.getString(AuthorTable.LAST_NAME))
                            .setDescription(resultSet.getString(AuthorTable.DESCRIPTION))
                            .build();
                }
                else {
                    throw new SQLException();
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateAuthor(Author author) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(AuthorTable.UPDATE)
        ) {
            statement.setInt(1, author.getId());
            statement.setString(2, author.getFirstName());
            statement.setString(3, author.getLastName());
            statement.setString(4, author.getDescription());
            return statement.executeUpdate() != 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteAuthorById(int id) {
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
    public List<Author> getAll() {
        return null;
    }
}
