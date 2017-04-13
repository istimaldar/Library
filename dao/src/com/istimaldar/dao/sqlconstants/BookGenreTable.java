package com.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public class BookGenreTable {
    public static final String ID = "id";
    public static final String BOOK_ID = "book_id";
    public static final String GENRE_ID = "genre_id";

    public static final String CREATE = "INSERT INTO library.book_genre (book_id, genre_id) VALUES (?, ?);";
    public static final String READ = "SELECT * FROM library.book_genre WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.book_genre SET book_id = ?, genre_id = ? WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.book_genre WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.book_genre;";
}
