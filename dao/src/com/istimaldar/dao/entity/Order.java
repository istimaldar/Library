package com.istimaldar.dao.entity;

import java.util.Date;

/**
 * Created by istimaldar
 */
public class Order {
    private int id;
    private boolean subscription;
    private Date beginning;
    private Date ending;
    private boolean closed;
    private Date closeDate;
    private Book book;

    public Order(int id, boolean subscription, Date beginning, Date ending, boolean closed, Date closeDate, Book book)
    {
        this.id = id;
        this.subscription = subscription;
        this.beginning = beginning;
        this.ending = ending;
        this.closed = closed;
        this.closeDate = closeDate;
        this.book = book;
    }
}
