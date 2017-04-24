package com.netcracker.istimaldar.dao.impl.mysql;

import com.netcracker.istimaldar.dao.connectionpool.ConnectionPool;
import com.netcracker.istimaldar.dao.daointerface.GenreDAO;
import com.netcracker.istimaldar.dao.beans.Genre;
import com.netcracker.istimaldar.dao.sqlconstants.GenreTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public class GenreDAOImpl implements GenreDAO {
    private static class GenreSingletonHolder {
        static final GenreDAOImpl INSTANCE = new GenreDAOImpl();
    }

    public static GenreDAO getInstance() {
        return GenreSingletonHolder.INSTANCE;
    }

    @Override
    public void createGenre(Genre genre) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(GenreTable.CREATE)
        ) {
            statement.setString(1, genre.getGenre());
            statement.setString(2, genre.getDescription());
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
    public Genre readGenreById(int id) {
        Genre result = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        try (Connection connection = pool.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(GenreTable.READ)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        result = new Genre(resultSet.getInt(GenreTable.ID),
                                resultSet.getString(GenreTable.GENRE),
                                resultSet.getString(GenreTable.DESCRIPTION));
                    }
                    else {
                        throw new SQLException();
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateGenre(Genre genre) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(GenreTable.UPDATE)
        ) {
            statement.setInt(1, genre.getId());
            statement.setString(2, genre.getGenre());
            statement.setString(3, genre.getDescription());
            return statement.executeUpdate() != 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteGenreById(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(GenreTable.DELETE)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }
}
