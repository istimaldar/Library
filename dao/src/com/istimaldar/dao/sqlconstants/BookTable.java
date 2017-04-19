package com.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public class BookTable
{
    public static final String ID = "id";
    public static final String AUTHOR_ID = "author_id";
    public static final String NAME = "name";
    public static final String LANGUAGE = "language";

    public static final String CREATE = "INSERT INTO library.book (author_id, name, language) VALUES (?, ?, ?);";
    public static final String READ = "SELECT * FROM library.book WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.book SET id = ?, author_id = ?, name = ?, language = ? " +
            "WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.book WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.book;";
}
