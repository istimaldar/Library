import com.netcracker.istimaldar.dao.beans.Author;
import com.netcracker.istimaldar.dao.daointerface.AuthorDAO;
import com.netcracker.istimaldar.dao.factory.DAOFactory;
import com.netcracker.istimaldar.dao.factory.MySqlDAOFactory;

import java.sql.SQLException;

/**
 * Created by istimaldar
 */
public class Main {
    public static void main(String [] args) throws SQLException {
        DAOFactory factory  = MySqlDAOFactory.getInstance();
        AuthorDAO bookDAO = factory.getAuthorDAO();
        //bookDAO.createAuthor(Author.newBuilder().setFirstName("a").setLastName("b").setDescription("c").build());

    }
}
