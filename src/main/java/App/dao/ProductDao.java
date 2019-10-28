package App.dao;

import App.model.Product;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long> {
}
