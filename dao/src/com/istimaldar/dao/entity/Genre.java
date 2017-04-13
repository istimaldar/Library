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
}
