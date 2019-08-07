package App.dao;

import App.model.User;
import App.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        UserDetails userDetails = user.getUserDetails();
        if (userDetails != null && userDetails.getId() == null) {
            entityManager.persist(userDetails);
        }
        entityManager.persist(user);
    }

    @Override
    public User get(Long userID) {
        return entityManager.find(User.class, userID);
    }

    @Override
    public void update(User user) {
        UserDetails userDetails = user.getUserDetails();
        if (userDetails != null) {
            userDetails = entityManager.merge(userDetails);
            user.setUserDetails(userDetails);
        }
        entityManager.merge(user);
    }

    @Override
    public void remove(User user) {
        User deleteUser = entityManager.merge(user);
        entityManager.remove(deleteUser.getUserDetails());
        entityManager.remove(deleteUser);
    }
}
