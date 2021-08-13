package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ProductName")
    private String ProductName;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String Brand;
    private int Price;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shop_cart> carts;

    public Products() {
    }

    public Products(String productName, String brand, int price) {
        this.ProductName = productName;
        this.Brand = brand;
        this.Price = price;
        carts = new ArrayList<>();
    }

    public void addCart(Shop_cart cart) {
        cart.setProducts(this);
        carts.add(cart);
    }

    public void removeCart(Shop_cart cart) {
        carts.remove(cart);
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public List<Shop_cart> getCart() {
        return carts;
    }

    public void setCarts(List<Shop_cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", ProductName='" + ProductName + '\'' +
                ", brand=" + Brand + '\'' +
                ", price=" + Price +
                '}';
    }
}
