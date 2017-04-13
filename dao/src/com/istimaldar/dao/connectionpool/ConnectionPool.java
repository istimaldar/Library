package com.istimaldar.dao.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Created by istimaldar
 */
public class ConnectionPool {
    private String driverName;
    private String url;
    private String user;
    private String password;
    private int poolSize;
    private static final BasicDataSource dataSource = new BasicDataSource();

    private ConnectionPool() {
        MySqlPropertyManager propertyManager = MySqlPropertyManager
                .getInstance();
        this.driverName = propertyManager.getValue(MySqlParameter.DB_DRIVER);
        this.url = propertyManager.getValue(MySqlParameter.DB_URL);
        this.user = propertyManager.getValue(MySqlParameter.DB_USER);
        this.password = propertyManager.getValue(MySqlParameter.DB_PASSWORD);
        try {
            this.poolSize = Integer.parseInt(propertyManager
                    .getValue(MySqlParameter.DB_POLL_SIZE));
        } catch (NumberFormatException e) {
            poolSize = 10;
            System.err.println("Invalid number format");
        }
    }

    private static class ConnectionPoolSingletonHolder {
        static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolSingletonHolder.INSTANCE;
    }

    public void initPoolData() throws SQLException {
            dataSource.setDriverClassName(driverName);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            dataSource.setMaxTotal(poolSize);
    }

    public void dispose() throws SQLException {
        dataSource.close();
    }

    public ResultSet executeQuere(String request, String [] parametres) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(request)
        ) {
            for (int i = 1; i <= parametres.length; i++) {
                statement.setString(i, parametres[i - 1]);
            }
            return statement.executeQuery();
        }
    }

    public int executeUpdate(String request, String [] parametres) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(request)
        ) {
            for (int i = 1; i <= parametres.length; i++) {
                statement.setString(i, parametres[i - 1]);
            }
            return statement.executeUpdate();
        }
    }
}
