package App.dao;

import App.model.Order;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {
}
