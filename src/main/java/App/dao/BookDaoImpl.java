package App.dao;

import App.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book get(Long bookID) {
        return entityManager.find(Book.class, bookID);
    }

    @Override
    @Transactional
    public void update(Book book) {
        //objects need to have master key
        entityManager.merge(book);
    }

    @Override
    @Transactional
    public void delete(Long bookID) {
        entityManager.remove(entityManager.find(Book.class, bookID));
    }
}
