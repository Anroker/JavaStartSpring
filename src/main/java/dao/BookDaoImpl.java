package dao;

import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public BookDaoImpl() {
        String persistenceUnitName = "myPersistenceUnit";
        managerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = managerFactory.createEntityManager();
    }

    public void save(Book book) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
    }

    public Book get(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void cleanUp() {
        entityManager.close();
        managerFactory.close();
    }
}
