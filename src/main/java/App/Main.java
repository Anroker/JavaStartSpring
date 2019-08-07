package App;

import App.dao.BookDao;
import App.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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

        System.out.println("Book saved");

        //System.out.println(bookDao.get(1L));
        System.out.println(daoBoot.get(1L));
        //context.close();
        contextBoot.close();
    }


}
