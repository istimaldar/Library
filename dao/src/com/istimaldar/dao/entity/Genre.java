package com.istimaldar.dao.entity;

/**
 * Created by istimaldar
 */
public class Genre {
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
}
