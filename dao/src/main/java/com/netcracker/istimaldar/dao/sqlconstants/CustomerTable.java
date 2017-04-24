package com.netcracker.istimaldar.dao.sqlconstants;

/**
 * Created by istimaldar
 */
public class CustomerTable {
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String ORDER_ID = "order_id";

    public static final String CREATE = "INSERT INTO library.customer (first_name, last_name) VALUES (?, ?);";
    public static final String READ = "SELECT c.id, c.first_name, c.last_name, bo.id order_id, " +
            "bo.subscription, bo.beginning, " +
            "bo.ending, bo.closed, bo.close_date, bo.book_id FROM library.customer c " +
            "LEFT JOIN library.book_order bo ON bo.customer_id = c.id; WHERE id = ?;";
    public static final String UPDATE = "UPDATE library.customer SET id = ?, first_name = ?, last_name = ? " +
            "WHERE id = ?;";
    public static final String DELETE = "DELETE FROM library.customer WHERE id = ?;";
    public static final String READ_ALL = "SELECT * FROM library.customer;";
}
