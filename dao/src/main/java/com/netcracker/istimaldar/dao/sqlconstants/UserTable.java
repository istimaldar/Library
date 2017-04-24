package com.netcracker.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public class UserTable {
    public static final String ID = "id";
    public static final String LOGIN = "login";
    public static final String HPASSWORD = "hpassword";
    public static final String EMAIL = "email";

    public static final String CREATE = "INSERT INTO library.userl (login, hpassword, email) VALUES (?, ?, ?);";
    public static final String READ = "SELECT * FROM library.userl WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.userl SET id = ?, login = ?, hpassword = ?, email = ? " +
            "WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.userl WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.userl;";
}
