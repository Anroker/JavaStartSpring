package App;

import App.dao.BookDao;
import App.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ConfigurableApplicationContext contextBoot = SpringApplication.run(Main.class, args);

        //BookDao bookDao = context.getBean(BookDao.class);
        BookDao daoBoot = contextBoot.getBean(BookDao.class);
        Book book = new Book("123498765", "Wolf from Spring Boot", "Jordan Belfort");
        //bookDao.save(book);
        daoBoot.save(book);


        Book book1 = new Book("0987654321112", "New Book For Spring Boog", "Marcin Głąb");
        book1.setId(1L);
        daoBoot.update(book1);

        Book findBook = daoBoot.get(1L);
        System.out.println("Book that was get: " + findBook);

        daoBoot.delete(1L);
        Book book2 = daoBoot.get(1L);

        System.out.println("Book that was removed: " + book2);

        //context.close();
        contextBoot.close();
    }


}
