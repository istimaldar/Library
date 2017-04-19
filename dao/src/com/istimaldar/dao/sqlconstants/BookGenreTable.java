package com.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public class BookGenreTable {
    public static final String ID = "id";
    public static final String BOOK_ID = "book_id";
    public static final String GENRE_ID = "genre_id";

    public static final String CREATE = "INSERT INTO library.book_genre (book_id, genre_id) VALUES (?, ?);";
    public static final String READ = "SELECT b.id, b.author_id, b.name, b.language, a.first_name, a.last_name, " +
            "a.description, bg.genre_id, g.genre, g.description FROM library.book b " +
            "INNER JOIN library.author a ON b.author_id = a.id INNER JOIN library.book_genre bg ON bg.book_id = b.id " +
            "INNER JOIN library.genre g ON bg.genre_id = g.id WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.book_genre SET id = ?, book_id = ?, genre_id = ? WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.book_genre WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.book_genre;";
}
