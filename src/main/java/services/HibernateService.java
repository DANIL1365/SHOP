package services;

import dao.HibernateDao;
import models.Products;
import models.User;
import models.Shop_cart;
import models.Orders;

import java.util.List;

public class HibernateService extends HibernateDao {

    private HibernateDao usersDao = new HibernateDao();

    public HibernateService() {
    }

    public User findUser(int id) {
        return usersDao.findByIdUser(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAllUser();
    }

    // Products
    public Products findProducts(int id) {
        return usersDao.findByIdProducts(id);
    }

    public void saveProducts(Products products) {
        usersDao.save(products);
    }

    public void deleteProducts(Products products) {
        usersDao.delete(products);
    }

    public void updateProducts(Products products) {
        usersDao.update(products);
    }

    public List<Products> findAllProducts() {
        return usersDao.findAllProducts();
    }

    public Shop_cart findShopById(int id) {
        return usersDao.findShopById(id);
    }

    public Orders findOrdersById(int id) {
       return usersDao.findOrdersById(id);
    }


}