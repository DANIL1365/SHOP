package dao;

import models.Products;
import models.User;
import models.Shop_cart;
import models.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import utils.HibernateSessionFactoryUtil;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateDao implements DAO {


        private SessionFactory factory;
        private Session session = null;
        private static Logger logger = LogManager.getLogger();

        private HibernateDao() {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Products.class)
                    .addAnnotatedClass(Shop_cart.class)
                    .addAnnotatedClass(Orders.class)
                    .buildSessionFactory();
            logger.info("Connected to database with hibernate");
        }

        private static HibernateDao instance = null;

        public static HibernateDao startWorkWithDatabase() {
            if (instance == null){
                instance = new HibernateDao();
                logger.info("New object of 'WorkWithHibernate'");
            }
            return instance;
        }


        @Override
        public List<User> findAllUser(){

            try {
                session = factory.getCurrentSession();
                session.beginTransaction();

                List<User> users = session.createQuery("from User").getResultList();
                return users;

            } catch (Throwable e) {
                logger.warn("Table user wasn't showed");
                return null;
            }
            finally {
                session.close();
            }

        }
        @Override
        public List<Products> findAllProducts(){

            try {
                session = factory.getCurrentSession();
                session.beginTransaction();

                List<Products> products = session.createQuery("from Products ").getResultList();
                session.close();
                return products;

            } catch (Throwable e) {
                logger.warn("Table product wasn't showed");
                session.close();
                return null;
            }

        }

        @Override
        public boolean saveUser(User newUser) {

            try {
                session = factory.getCurrentSession();
                session.beginTransaction();

                session.save(newUser);

                session.getTransaction().commit();
                session.close();
                return true;
            } catch (Throwable e){
                logger.warn("The user wasn't added");
                session.close();
                return false;
            }

        }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void updateProducts(Products products) {

    }

        @Override
        public boolean saveProducts(Products newProduct) {

            try {
                session = factory.getCurrentSession();
                session.beginTransaction();

                session.save(newProduct);

                session.getTransaction().commit();
                session.close();
                return true;
            } catch (Throwable e){
                logger.warn("The product wasn't added");
                session.close();
                return false;
            }

        }

        @Override
        public boolean deleteProducts(Products products) {

            try {
                session = factory.getCurrentSession();
                session.beginTransaction();

                session.delete(products);

                session.getTransaction().commit();
                session.close();
                return true;
            } catch (Throwable e){
                logger.warn("The product wasn't added");
                session.close();
                return false;
            }

        }

    @Override
    public boolean deleteUser(User user) {

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.delete(user);

            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Throwable e){
            logger.warn("The product wasn't added");
            session.close();
            return false;
        }

    }


        @Override
        public User findByIdUser(int id) {
            try {
                session = factory.getCurrentSession();
                session.beginTransaction();

                User user = session.get(User.class, id);

                session.close();
                return user;
            } catch (Throwable e) {
                logger.warn("The user wasn't get by Id");
                session.close();
                return null;
            }
        }
        @Override
        public Products findByIdProducts(int id) {
            try {
                session = factory.getCurrentSession();
                session.beginTransaction();

                Products product = session.get(Products.class, id);

                session.close();
                return product;
            } catch (Throwable e) {
                logger.warn("The product wasn't get by Id");
                session.close();
                return null;
            }
        }

    @Override
    public Shop_cart findShopById(int id){
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Shop_cart shop_cart = session.get(Shop_cart.class, id);

            session.close();
            return shop_cart;
        } catch (Throwable e) {
            logger.warn("The order wasn't get by Id");
            session.close();
            return null;
        }
    }

    @Override
    public Orders findOrdersById(int id){
            try {
                session = factory.getCurrentSession();
                session.beginTransaction();

                Orders orders = session.get(Orders.class, id);

                session.close();
                return orders;
            } catch (Throwable e) {
                logger.warn("The order wasn't get by Id");
                session.close();
                return null;
            }
        }
    @Override
    public boolean addProductToUsersCart(Products products, User user, Shop_cart shop_cart) {

//        try {
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            user = session.get(User.class, user.getId());
//            products = session.get(Products.class, products.getId());
//
//
//            user.addCart(products);
//            session.save(user);
//            session.getTransaction().commit();
//            session.close();
//            return true;
//
//
//
//        } catch (Throwable e){
//            logger.warn("The product wasn't added to user's cart");
//            e.printStackTrace();
//            session.close();
//            return false;
//        }
        return true;

    }

        public void finishWork(){
            factory.close();
            logger.info("Connected to database was closed");
        }
    }
