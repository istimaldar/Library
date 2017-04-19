package com.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public class AuthorTable {
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String DESCRIPTION = "description";

    public static final String CREATE = "INSERT INTO library.author (first_name, last_name, description) " +
            "VALUES (? , ?, ?);";
    public static final String READ = "SELECT * FROM library.author WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.author SET id = ?, first_name = ?, last_name = ?, " +
            "description = ? WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.author WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.author;";
}
