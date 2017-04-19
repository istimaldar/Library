package com.istimaldar.dao.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by istimaldar
 */
public class Book implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id && name.equals(book.name) && language.equals(book.language)
                && author.equals(book.author) && genres.equals(book.genres);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + genres.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", author=" + author +
                ", genres=" + genres +
                '}';
    }
}
