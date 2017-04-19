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
    private int customerID;

    public Order(int id, boolean subscription, Date beginning, Date ending, boolean closed, Date closeDate,
                 Book book, int customerID)
    {
        this.id = id;
        this.subscription = subscription;
        this.beginning = beginning;
        this.ending = ending;
        this.closed = closed;
        this.closeDate = closeDate;
        this.book = book;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public Date getBeginning() {
        return beginning;
    }

    public Date getEnding() {
        return ending;
    }

    public boolean isClosed() {
        return closed;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public Book getBook() {
        return book;
    }

    public int getCustomerID() {
        return customerID;
    }
}
