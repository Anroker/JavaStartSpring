package App.dao;

import App.model.Book;

public interface BookDao {

    void save(Book book);
    Book get(Long bookID);
    void update(Book book);
    void delete(Long bookID);

}
