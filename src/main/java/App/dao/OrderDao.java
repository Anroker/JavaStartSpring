package App.dao;

import App.model.Order;
import App.model.Product;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {

    public void addProductsToOrder(Long orderID, Product...products) {
        Order order = get(orderID);
        if (order!= null) {
            for (Product product: products) {
                order.getProducts().add(product);
            }
        }
    }
}
