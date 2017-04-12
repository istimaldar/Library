package com.istimaldar.dao.entity;

/**
 * Created by istimaldar
 */
public class Book {
    int id;
    int name;
    String language;
    Author author;

    public Book(int id, int name, String language, Author author)
    {
        this.id = id;
        this.name = name;
        this.language = language;
        this.author = author;
    }
}
