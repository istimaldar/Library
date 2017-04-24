package com.netcracker.istimaldar.dao.impl.mysql;

import com.netcracker.istimaldar.dao.beans.User;
import com.netcracker.istimaldar.dao.connectionpool.ConnectionPool;
import com.netcracker.istimaldar.dao.daointerface.UserDAO;
import com.netcracker.istimaldar.dao.sqlconstants.UserTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public class UserDAOImpl implements UserDAO
{
    @Override
    public void createCustomer(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(UserTable.CREATE)
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHpassword());
            statement.setString(3, user.getEmail());
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
    public User readCustomerById(int id) {
        User result = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(UserTable.READ)
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = new User(resultSet.getInt(UserTable.ID),
                            resultSet.getString(UserTable.LOGIN),
                            resultSet.getString(UserTable.HPASSWORD),
                            resultSet.getString(UserTable.EMAIL));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateCustomer(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(UserTable.UPDATE)
        ) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getHpassword());
            statement.setString(4, user.getEmail());
            int rows = statement.executeUpdate();
            if (rows == 0) {
                throw new SQLException();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void deleteCustomerById(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        try (
                Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(UserTable.DELETE)
        ) {
            statement.setInt(1, id);
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
    public List<User> getAll() {
        return null;
    }
}
