package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_cart")
public class Shop_cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId")
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    @Column(name = "ProductCount")
    private int ProductCount;

    private int price;

    @OneToMany(mappedBy = "shopCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders;


    public Shop_cart() {
    }

    public Shop_cart(int ProductCount, int price) {
        this.ProductCount = ProductCount;
        this.price = price;
        orders = new ArrayList<>();
    }

    public Shop_cart(int id, int ProductCount, int price) {
        this.id = id;
        this.ProductCount = ProductCount;
        this.price = price;

    }

    public void addOrders(Orders order) {
        order.setShopCart(this);
        orders.add(order);
    }

    public void removeOrder(Orders order) {
        orders.remove(order);
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getProductCount() {
        return ProductCount;
    }

    public void setProductCount(int ProductCount) {
        this.ProductCount = ProductCount;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public List<Orders> getOrder() {
        return orders;
    }

    public void setOrder(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ProductCount=" + ProductCount +
                "price=" + price + '\n';
    }
}