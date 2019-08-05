package App.dao;

import App.model.Book;

public interface BookDao {

    void save(Book book);
    Book get(Long id);

}
