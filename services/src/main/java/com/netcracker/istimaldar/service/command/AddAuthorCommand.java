package com.netcracker.istimaldar.service.command;

import com.netcracker.istimaldar.dao.beans.Author;
import com.netcracker.istimaldar.dao.factory.MySqlDAOFactory;
import com.netcracker.istimaldar.service.constants.RequestConstants;
//import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by istimaldar
 */
public class AddAuthorCommand implements ActionCommand {
    //private Logger logger = Logger.getLogger(AddAuthorCommand.class.getName());

    public String execute(HttpServletRequest request) {
        String firstName = request.getParameter(RequestConstants.FIRST_NAME);
        String lastName = request.getParameter(RequestConstants.LAST_NAME);
        String description = request.getParameter(RequestConstants.DESCRIPTION);
        Author author = Author.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDescription(description)
                .build();
        try {
            MySqlDAOFactory.getInstance().getAuthorDAO().createAuthor(author);
        }
        catch (SQLException e) {
            //logger.error("SERVICE:", e);
        }
        return null;
    }
}
