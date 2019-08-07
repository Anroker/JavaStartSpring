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

    public Book get(Long id) {
        return entityManager.find(Book.class, id);
    }
}
