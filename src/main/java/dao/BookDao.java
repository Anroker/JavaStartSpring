package dao;

import model.Book;

public interface BookDao {

    public void save(Book book);
    public Book get(Long id);
    public void cleanUp();
}
