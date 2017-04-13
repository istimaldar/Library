package com.istimaldar.dao.entity;

/**
 * Created by istimaldar
 */
public class Book {
    private int id;
    private int name;
    private String language;
    private Author author;
    private boolean available;

    public Book(int id, int name, String language, Author author)
    {
        this.id = id;
        this.name = name;
        this.language = language;
        this.author = author;
        this.available = true;
    }
}
