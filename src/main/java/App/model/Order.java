package App.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "order_products",
            joinColumns = {
                    @JoinColumn(name = "order_id",
                                referencedColumnName = "order_id"
                )},
                inverseJoinColumns = {
                    @JoinColumn(name = "product_id",
                                referencedColumnName = "id_product")}
    )
    private List<Product> products;

    @Column(name = "details", length = 512)
    private String orderDetails;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order() {
    }

    public Order(List<Product> product, String orderDetails) {
        this.products = product;
        this.orderDetails = orderDetails;
    }

    public Order(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order [id=" + id
                + ", orderDetails=" + orderDetails
                + ", client=" + client.getFirstName() + " " + client.getLastName() + products.size()
                + ",\n products=" + products + "]";
    }
}
