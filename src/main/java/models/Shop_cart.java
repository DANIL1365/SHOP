package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shop_cart")
public class Shop_cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId")
    private Products ProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User UserId;

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

//    public Shop_cart(int ProductId, int UserId, int ProductCount, int price) {
//        this.id = id;
//        this.ProductCount = ProductCount;
//        this.price = price;
//
//    }

    public void addOrders(Orders order) {
        order.setShopCart(this);
        orders.add(order);
    }

    public User getUserId(){
        return UserId;
    }

    public Products getProductId(){
        return ProductId;
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
        return UserId;
    }

    public void setUser(User user) {
        this.UserId = user;
    }

    public Products getProducts() {
        return ProductId;
    }

    public void setProducts(Products products) {
        this.ProductId = products;
    }

    public List<Orders> getOrder() {
        return orders;
    }

    public void setOrder(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ProductId=" + ProductId +
                "UserId=" + UserId +
                "ProductCount=" + ProductCount +
                "price=" + price + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop_cart)) return false;
        Shop_cart shop_cart = (Shop_cart) o;
        return ProductId.equals(shop_cart.ProductId) && UserId.equals(shop_cart.UserId) && ProductCount == shop_cart.ProductCount && price == shop_cart.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductId ,UserId ,ProductCount, price);
    }
}