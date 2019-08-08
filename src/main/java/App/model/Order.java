package App.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    private String product;

    @Column(name = "details", length = 512)
    private String orderDetails;

    public Order() {
    }

    public Order(String product, String orderDetails) {
        this.product = product;
        this.orderDetails = orderDetails;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", product='" + product + '\'' +
               ", orderDetails='" + orderDetails + '\'' +
               '}';
    }
}
