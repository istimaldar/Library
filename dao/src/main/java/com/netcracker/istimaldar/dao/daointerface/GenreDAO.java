package com.netcracker.istimaldar.dao.daointerface;

import com.netcracker.istimaldar.dao.beans.Genre;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public interface GenreDAO {
    void createGenre(Genre genre) throws SQLException;
    Genre readGenreById(int id);
    boolean updateGenre(Genre genre);
    void deleteGenreById(int id);
    List<Genre> getAll();
}
