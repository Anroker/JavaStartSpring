package dao;

import model.Book;

public interface BookDao {

    void save(Book book);
    Book get(Long id);
    void cleanUp();
}
