package com.netcracker.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public final class GenreTable {
    private GenreTable() {

    }

    public static final String ID = "id";
    public static final String GENRE = "genre";
    public static final String DESCRIPTION = "description";

    public static final String CREATE = "INSERT INTO library.genre (genre, description) VALUES (?, ?);";
    public static final String READ = "SELECT * FROM library.genre WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.genre SET id = ?, genre = ?, description = ? WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.genre WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.genre;";
}
