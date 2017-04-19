package com.istimaldar.dao.entity;

import java.util.List;

/**
 * Created by istimaldar
 */
public class Book {
    private int id;
    private String name;
    private String language;
    private Author author;
    private List<Genre> genres;

    public Book(int id, String name, String language, Author author, List<Genre> genres)
    {
        this.id = id;
        this.name = name;
        this.language = language;
        this.author = author;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Genre> getGenres() {
        return genres;
    }
}
