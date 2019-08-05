package App.dao;

import App.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceUnit
    private EntityManagerFactory managerFactory;
    //private ;

    public BookDaoImpl() {
    }


    public void save(Book book) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
        entityManager.close();
    }

    public Book get(Long id) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }
}
