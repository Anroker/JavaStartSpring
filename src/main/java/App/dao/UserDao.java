package App.dao;

import App.model.User;

public interface UserDao {
    void save(User user);
    User get(Long userID);
    void update(User user);
    void remove(User user);
}
