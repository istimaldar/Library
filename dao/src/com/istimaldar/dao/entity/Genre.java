package com.istimaldar.dao.entity;

import java.io.Serializable;

/**
 * Created by istimaldar
 */
public class Genre implements Serializable {
    private int id;
    private String genre;
    private String description;

    public Genre(int id, String genre, String description)
    {
        this.id = id;
        this.genre = genre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre1 = (Genre) o;

        return id == genre1.id && genre.equals(genre1.genre) && description.equals(genre1.description);
    }

    @Override
    public int hashCode() {
        int result = genre.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
