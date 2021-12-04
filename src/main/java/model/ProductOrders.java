package model;

import javax.persistence.*;

@Entity
@Table(name = "product_orders")
public class ProductOrders {

    @EmbeddedId   // primary key
    private ProductOrdersId id = new ProductOrdersId();

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orders_id", insertable = false, updatable = false)
    private Orders orders;

    private String description;

}



