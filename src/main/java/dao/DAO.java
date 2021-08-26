package dao;


import models.Orders;
import models.Products;
import models.Shop_cart;
import models.User;

import java.util.List;

public interface DAO {
    public abstract User findByIdUser(int id);
    public abstract boolean saveUser(User user);
    public abstract void updateUser(User user);
    public abstract boolean deleteUser(User user);

    public abstract Products findByIdProducts(int id);
    public abstract boolean saveProducts(Products products);
    public abstract void updateProducts(Products products);
    public abstract boolean deleteProducts(Products products);

    public abstract Shop_cart findShopById(int id);
    public abstract Orders findOrdersById(int id);
    public abstract List<User> findAllUser();
    public abstract List<Products> findAllProducts();

    public abstract boolean addProductToUsersCart(Products products, User user, Shop_cart shop_cart);

    public abstract void finishWork();

}
