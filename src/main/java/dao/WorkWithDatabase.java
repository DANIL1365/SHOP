package dao;


import models.Orders;
import models.Products;
import models.Shop_cart;
import models.User;

import java.util.List;

public interface WorkWithDatabase {
    public abstract User findByIdUser(int id);
    public abstract void save(User user);
    public abstract void update(User user);
    public abstract void delete(User user);

    public abstract Products findByIdProducts(int id);
    public abstract void save(Products products);
    public abstract void update(Products products);
    public abstract void delete(Products products);

    public abstract Shop_cart findShopById(int id);
    public abstract Orders findOrdersById(int id);
    public abstract List<User> findAllUser();
    public abstract List<Products> findAllProducts();
}
