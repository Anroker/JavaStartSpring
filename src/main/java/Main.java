import dao.BookDao;
import dao.BookDaoImpl;
import model.Book;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("123498765", "Wilk z Wall Street", "Jordan Belfort");
        BookDao bookDao = new BookDaoImpl();
        bookDao.save(book);
        System.out.println("Book saved");

        System.out.println(bookDao.get(1L));
        bookDao.cleanUp();
    }


}
