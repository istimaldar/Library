package com.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public class OrderTable {
    public static final String ID = "id";
    public static final String SUBCRIPTION = "subscription";
    public static final String BEGINNING = "beginning";
    public static final String ENDING = "ending";
    public static final String CLOSED = "closed";
    public static final String CLOSE_DATE = "close_date";
    public static final String BOOK_ID = "book_id";
    public static final String CUSTOMER_ID = "customer_id";

    public static final String CREATE = "INSERT INTO library.book_order (subscription, beginning, ending, closed," +
            " close_date, book_id, customer_id) VALUES (?, ?, ?, ?, ?, ?, ?);";
    public static final String READ = "SELECT * FROM library.order WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.book_order SET id = ?, subscription = ?, beginning = ?, " +
            "ending = ?, closed = ?, close_date = ?, book_id = ?, customer_id = ? WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.book_order WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.book_order;";
}
