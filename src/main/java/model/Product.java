package model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", insertable = false, updatable = false)
    private int productId;

    @Column(name = "name")
    private String productName;

    @Column(name = "product_unit")
    private String productUnit;

    @Column(name = "price_per_unit")
    private double pricePerUnit;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "specification")
    private String productSpecification;

    @Column(name = "min_order_quantity")
    private int minOrderQuantity;

    @Column(name = "now_in_stock")
    private int nowInStock;

    @Column(name = "order_time")
    private int orderTime;

    @Column(name = "country_code")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public int getMinOrderQuantity() {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(int minOrderQuantity) {
        this.minOrderQuantity = minOrderQuantity;
    }

    public int getNowInStock() {
        return nowInStock;
    }

    public void setNowInStock(int nowInStock) {
        this.nowInStock = nowInStock;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", currencyCode='" + currencyCode + '\'' +
                ", productSpecification='" + productSpecification + '\'' +
                ", minOrderQuantity=" + minOrderQuantity +
                ", nowInStock=" + nowInStock +
                ", orderTime=" + orderTime +
                ", countryCode='" + countryCode + '\'' +
                ", orders=" + orders +
                '}';
    }
}


