package App.dao;

import App.model.Client;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDao extends  GenericDao<Client, Long> {

    //Exception in thread "main" org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role:
    @Override
    public Client get(Long key) {
        Client client = super.get(key);
        client.getOrders().size();
        return client;
    }
}
