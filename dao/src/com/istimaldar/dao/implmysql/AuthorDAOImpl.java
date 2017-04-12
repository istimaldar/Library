package com.istimaldar.dao.implmysql;

import com.istimaldar.dao.daointerface.AuthorDAO;
import com.istimaldar.dao.entity.Author;

import java.util.List;

/**
 * Created by istimaldar
 */
public class AuthorDAOImpl implements AuthorDAO {
    private static class AuthorSingletonHolder {
        static final AuthorDAOImpl instance = new AuthorDAOImpl();
    }

    public static AuthorDAO getInstance() {
        return AuthorSingletonHolder.instance;
    }

    @Override
    public void createAuthor(Author author) {

    }

    @Override
    public Author readAuthorById(int id) {
        return null;
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteAuthorById(int id) {

    }

    @Override
    public List<Author> getAll() {
        return null;
    }
}
