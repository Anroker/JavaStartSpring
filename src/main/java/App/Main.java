package App;

import App.dao.*;
import App.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ConfigurableApplicationContext contextBoot = SpringApplication.run(Main.class, args);

        Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
        ClientDao clientDao = contextBoot.getBean(ClientDao.class);
        clientDao.save(client);

        Order order = new Order("z dostawą do domu");
        order.setClient(client);
        OrderDao orderDao = contextBoot.getBean(OrderDao.class);
        orderDao.save(order);

        Product product1 = new Product("Telewizor LG 42'", 4800.0, "dolby surround");
        Product product2 = new Product("Telefon Apple iPhone SE", 2200.0, "pokrowiec gratis");
        ProductDao productDao = contextBoot.getBean(ProductDao.class);
        productDao.save(product1);
        productDao.save(product2);

        orderDao.addProductsToOrder(order.getId(), product1, product2);

        Client getClient = clientDao.get(client.getId());
        System.out.println("\n"+getClient);


//        Client client = new Client("Marcin", "Glab","City 54, City");
//        ClientDao clientDao = contextBoot.getBean(ClientDao.class);
//        clientDao.save(client);
//        System.out.println(client);
//
//        Order order = new Order("LG TV", "Details of product");
//        order.setClient(client);
//        OrderDao orderDao = contextBoot.getBean(OrderDao.class);
//        orderDao.save(order);
//        System.out.println(order);
//
//        Order getOrder = orderDao.get(1L);
//        System.out.println("Get order: " + getOrder);
//
//        Client getClient = clientDao.get(1L);
//        System.out.println("Client:" + getClient);


        /*
        BookDao bookDao = context.getBean(BookDao.class);
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
*/
    }


}
