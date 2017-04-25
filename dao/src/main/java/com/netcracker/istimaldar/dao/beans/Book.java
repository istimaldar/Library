package com.netcracker.istimaldar.dao.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by istimaldar
 */
public class Book implements Cloneable, Serializable {
    private int id;
    private String name;
    private String language;
    private Author author;
    private List<Genre> genres;

    private Book() {

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
                ", login='" + name + '\'' +
                ", language='" + language + '\'' +
                ", author=" + author +
                ", genres=" + genres +
                '}';
    }

    public static BookBuilder newBuilder() {
        return new Book().new BookBuilder();
    }

    public class BookBuilder {
        private BookBuilder() {

        }

        public BookBuilder setId(int id) {
            Book.this.id = id;
            return this;
        }

        public BookBuilder setName(String name) {
            Book.this.name = name;
            return this;
        }

        public BookBuilder setLanguage(String language) {
            Book.this.language = language;
            return this;
        }

        public BookBuilder setAuthor(Author author) {
            Book.this.author = author;
            return this;
        }

        public BookBuilder setGenres(List<Genre> genres) {
            Book.this.genres = genres;
            return this;
        }

        public Book build() {
            return Book.this;
        }
    }
}
