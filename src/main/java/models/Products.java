package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ProductName")
    private String ProductName;
    private String Brand;
    private int Price;

    @OneToMany(mappedBy = "ProductId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shop_cart> carts;


    public Products() {
    }

    public Products(String productName, String brand, int price) {
        this.ProductName = productName;
        this.Brand = brand;
        this.Price = price;
        carts = new ArrayList<>();
    }

    public Products(int id, String ProductName, String Brand, int Price) {
        this.id = id;
        this.ProductName = ProductName;
        this.Brand = Brand;
        this.Price = Price;
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

    public void setId(int id){
        this.id = id;
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
        return "Products{" +
                "id=" + id +
                ", ProductName='" + ProductName + '\'' +
                ", brand=" + Brand + '\'' +
                ", price=" + Price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        Products products = (Products) o;
        return ProductName.equals(products.ProductName) && Brand.equals(products.Brand) && Price == products.Price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductName, Brand, Price);
    }
}
