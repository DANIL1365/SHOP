//package models;
//
//import org.hibernate.type.DateType;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "orders")
//public class Orders {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Shop_cartId")
//    private Shop_cart shopCart;
//
//    @Column(name = "ProductCount")
//    private int ProductCount;
//
//    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
//    private DateType Created_At;
//
//    private String Delivery_city;
//
//    private int Price;
//
//
//    public Orders() {
//    }
//
//    public Orders(int ProductCount, DateType Created_At, String Delivery_city, int Price) {
//        this.ProductCount = ProductCount;
//        this.Created_At = Created_At;
//        this.Delivery_city = Delivery_city;
//        this.Price = Price;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public int getCount() {
//        return ProductCount;
//    }
//
//    public void setCount(int ProductCount) {
//        this.ProductCount = ProductCount;
//    }
//
//    public DateType getCreated_At() {
//        return Created_At;
//    }
//
//    public void setCreated_At(DateType Created_At) {
//        this.Created_At = Created_At;
//    }
//
//    public String getDelivery_city() {
//        return Delivery_city;
//    }
//
//    public void setDelivery_city(String Delivery_city) {
//        this.Delivery_city = Delivery_city;
//    }
//
//    public int getPrice() {
//        return Price;
//    }
//
//    public void setPrice(int Price) {
//        this.Price = Price;
//    }
//
//    public Shop_cart getShopCart() {
//        return shopCart;
//    }
//
//    public void setShopCart(Shop_cart shopCart) {
//        this.shopCart = shopCart;
//    }
//
//    @Override
//    public String toString() {
//        return ProductCount + " " + Created_At + " " + Delivery_city + " " + Price;
//    }
//}


