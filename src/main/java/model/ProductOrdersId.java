package model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductOrdersId implements Serializable {
    @Column(name = "orders_id")
    private Integer ordersId;

    @Column(name = "product_id")
    private Integer productId;

}

