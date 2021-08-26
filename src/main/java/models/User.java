package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String Name;
    private String Number;
    private String Email;

    @OneToMany(mappedBy = "UserId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shop_cart> carts;

    public User() {
    }

    public User(String name, String number, String email) {
        this.Name = name;
        this.Number = number;
        this.Email = email;
        carts = new ArrayList<>();
    }

    public User(int id, String Name, String Number, String Email) {
        this.id = id;
        this.Name = Name;
        this.Number = Number;
        this.Email = Email;
    }


    public void addCart(Shop_cart cart) {
        cart.setUser(this);
        carts.add(cart);
    }

    public void removeCart(Shop_cart cart) {
        carts.remove(cart);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        this.Number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public List<Shop_cart> getCart() {
        return carts;
    }

    public void setCarts(List<Shop_cart> carts) {
        this.carts = carts;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + Name + '\'' +
                ", number=" + Number + '\'' +
                ", email=" + Email +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Name.equals(user.Name) && Number.equals(user.Number) && Email.equals(user.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Number, Email);
    }

}