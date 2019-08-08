package App;

import App.dao.BookDao;
import App.dao.UserDao;
import App.dao.UserDetailsDao;
import App.model.Book;
import App.model.User;
import App.model.UserDetails;
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



        UserDao userDao = contextBoot.getBean(UserDao.class);
        User user = new User("johnny234", "strongPass", "johnny@gmail.com");

        userDao.save(user);


        UserDetails details = new UserDetails("John", "Kowalski", "Krakowska 55, Warszawa");
        user.setUserDetails(details);
        userDao.update(user);


        user.setPassword("passPass");
        user.getUserDetails().setFirstName("Piotr");
        userDao.update(user);


        User userFromDb = userDao.get(1L);
        System.out.println(userFromDb);


       // userDao.remove(user);


        userFromDb = userDao.get(1L);
        System.out.println(userFromDb);

        UserDetailsDao userDetailsDao = contextBoot.getBean(UserDetailsDao.class);
        UserDetails userDetails = userDetailsDao.get(1L);
        System.out.println("UserDetails: " + userDetails.getUser());
    }


}
