package com.istimaldar.dao.daointerface;

import com.istimaldar.dao.entity.Author;

import java.util.List;

/**
 * Created by istimaldar
 */
public interface AuthorDAO {
    void createAuthor(Author author);
    Author readAuthorById(int id);
    boolean updateAuthor(Author author);
    void deleteAuthorById(int id);
    List<Author> getAll();
}
