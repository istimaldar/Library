package com.netcracker.istimaldar.dao.daointerface;

import com.netcracker.istimaldar.dao.beans.Author;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by istimaldar
 */
public interface AuthorDAO {
    void createAuthor(Author author) throws SQLException;
    Author readAuthorById(int id);
    boolean updateAuthor(Author author);
    void deleteAuthorById(int id);
    List<Author> getAll();
}
