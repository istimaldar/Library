import com.istimaldar.dao.daointerface.BookDAO;
import com.istimaldar.dao.daointerface.GenreDAO;
import com.istimaldar.dao.entity.Book;
import com.istimaldar.dao.entity.Genre;
import com.istimaldar.dao.factory.DAOFactory;
import com.istimaldar.dao.factory.MySqlDAOFactory;

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
