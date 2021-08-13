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

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private int Price;

//    @OneToMany(mappedBy = "shop_cart", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Orders> orders;


    public Shop_cart() {
    }

    public Shop_cart(int price) {
        this.Price = price;
       // orders = new ArrayList<>();
    }

//    public void addOrders(Orders order) {
//        order.setShopCart(this);
//      //  orders.add(order);
//    }

//    public void removeOrder(Orders order) {
//        orders.remove(order);
//    }


    public int getId() {
        return id;
    }



    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
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

//    public List<Orders> getOrder() {
//        return orders;
//    }

//    public void setOrder(List<Orders> orders) {
//        this.orders = orders;
//    }

    @Override
    public String toString() {
        return "price=" + Price;
    }
}