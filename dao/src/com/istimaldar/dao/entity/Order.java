package com.istimaldar.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by istimaldar
 */
public class Order implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id && subscription == order.subscription && closed == order.closed
                && customerID == order.customerID && beginning.equals(order.beginning)
                && ending.equals(order.ending) && closeDate.equals(order.closeDate) && book.equals(order.book);
    }

    @Override
    public int hashCode() {
        int result = (subscription ? 1 : 0);
        result = 31 * result + beginning.hashCode();
        result = 31 * result + ending.hashCode();
        result = 31 * result + (closed ? 1 : 0);
        result = 31 * result + closeDate.hashCode();
        result = 31 * result + book.hashCode();
        result = 31 * result + customerID;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", subscription=" + subscription +
                ", beginning=" + beginning +
                ", ending=" + ending +
                ", closed=" + closed +
                ", closeDate=" + closeDate +
                ", book=" + book +
                ", customerID=" + customerID +
                '}';
    }
}
