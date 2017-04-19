package com.istimaldar.dao.daointerface;

import com.istimaldar.dao.entity.Genre;

import java.util.List;

/**
 * Created by istimaldar
 */
public interface GenreDAO {
    void createGenre(Genre customer);
    Genre readGenreById(int id);
    boolean updateGenre(Genre customer);
    void deleteGenreById(int id);
    List<Genre> getAll();
}
