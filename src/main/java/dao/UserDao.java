package dao;

import models.Products;
import models.User;
import models.Shop_cart;
//import models.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class UserDao {

    public User findByIdUser(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
// Products
    public Products findByIdProducts(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Products.class, id);
    }

    public void save(Products products) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(products);
        tx1.commit();
        session.close();
    }

    public void update(Products products) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(products);
        tx1.commit();
        session.close();
    }

    public void delete(Products products) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(products);
        tx1.commit();
        session.close();
    }

    public Shop_cart findShopById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Shop_cart.class, id);
    }

//    public Orders findOrdersById(int id) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Orders.class, id);
//    }

    public List<User> findAllUser() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    public List<Products> findAllProducts() {
        List<Products> productsList = (List<Products>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return productsList;
    }
}
