package utils;

import dao.DAO;
import dao.HibernateDao;
import dao.JDBCDao;
import models.Orders;
import models.Products;
import models.Shop_cart;
import models.User;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) throws SQLException {

        Logger logger = LogManager.getLogger();

  //      DAO hibernateDao = HibernateDao.startWorkWithDatabase();
      //  hibernateDao.deleteUser(hibernateDao.findByIdUser(114));

//        User user = new User("Артем", "0968904760", "Artem@gmail");
//        hibernateDao.saveUser(user);
//
//        Products products = new Products( "S500A", "LG", 29800);
//        hibernateDao.saveProducts(products);
//        Shop_cart product = new Shop_cart(1, 29800);
//        product.setUser(user);
//        product.setProducts(products);
//        user.addCart(product);
//        products.addCart(product);
//        Orders orders = new Orders(1,"2021-08-25", "Kievv", 29800);
//        orders.setShopCart(product);
//        product.addOrders(orders);
//        hibernateDao.updateUser(user);
//        hibernateDao.updateProducts(products);

        /////
        DAO jdbcDao = JDBCDao.startWorkWithDatabase();
        User user1 = jdbcDao.findByIdUser(111);
        logger.info(user1);
        Products products1 = jdbcDao.findByIdProducts(66);
        logger.info(products1);
        Shop_cart shopCart = jdbcDao.findShopById(34);
        logger.info(shopCart);
        Shop_cart shop_cart = new Shop_cart(1, 29800);
      //  shop_cart.setUser(user1);
       // shop_cart.setProducts(products1);
       // user1.addCart(shop_cart);
      //  products1.addCart(shop_cart);
        logger.debug(jdbcDao.addProductToUsersCart(products1,user1,shop_cart));
 //       User user2 = new User("Max","095432189","Max@gmail.com");
//        logger.info(jdbcDao.saveUser(user2));
//        logger.info(jdbcDao.findAllUser());
  //      logger.info(jdbcDao.deleteUser(jdbcDao.findByIdUser(74)));
//        Products products2 = new Products("A34G60","Mazeti",30000);
//        logger.info(jdbcDao.saveProducts(products2));
//        logger.info(jdbcDao.deleteProducts(jdbcDao.findByIdProducts(63)));
        jdbcDao.finishWork();

    }

}
