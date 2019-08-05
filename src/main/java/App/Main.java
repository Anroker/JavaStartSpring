package App;

import App.dao.BookDao;
import App.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        BookDao bookDao = context.getBean(BookDao.class);

        Book book = new Book("123498765", "Wolf from Spring", "Jordan Belfort");
        bookDao.save(book);

        System.out.println("Book saved");

        System.out.println(bookDao.get(1L));

        context.close();
    }


}
