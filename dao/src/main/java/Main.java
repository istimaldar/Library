import com.netcracker.istimaldar.dao.daointerface.BookDAO;
import com.netcracker.istimaldar.dao.beans.Book;
import com.netcracker.istimaldar.dao.beans.Genre;
import com.netcracker.istimaldar.dao.factory.DAOFactory;
import com.netcracker.istimaldar.dao.factory.MySqlDAOFactory;

/**
 * Created by istimaldar
 */
public class Main {
    public static void main(String [] args)
    {
        DAOFactory factory  = MySqlDAOFactory.getInstance();
        BookDAO bookDAO = factory.getBookDAO();
        Book book = bookDAO.readBookById(1);
        for (Genre genre : book.getGenres()) {
            System.out.println(genre.getGenre());
        }

    }
}
