package App.dao;

import App.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDetailsDao {

    private EntityManager entityManager;

    @Autowired
    public UserDetailsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserDetails get(Long id) {
        return entityManager.find(UserDetails.class, id);
    }
}
