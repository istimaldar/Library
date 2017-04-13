package com.istimaldar.dao.implmysql;

import com.istimaldar.dao.daointerface.GenreDAO;
import com.istimaldar.dao.entity.Genre;

import java.util.List;

/**
 * Created by istimaldar
 */
public class GenreDAOImpl implements GenreDAO {
    private static class GenreSingletonHolder {
        static final GenreDAOImpl instance = new GenreDAOImpl();
    }

    public static GenreDAO getInstance() {
        return GenreSingletonHolder.instance;
    }

    @Override
    public void createGenre(Genre customer) {

    }

    @Override
    public Genre readGenreById(int id) {
        return null;
    }

    @Override
    public void updateGenre(Genre customer) {

    }

    @Override
    public void deleteGenreById(int id) {

    }

    @Override
    public List<Genre> getAll() {
        return null;
    }
}
