package utils;

import models.Orders;
import models.Products;
import models.Shop_cart;
import models.User;
import services.HibernateService;
import utils.JDBCWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        HibernateService userService = new HibernateService();
        User user = new User("Дима", "0968904760", "Dima@gmail");
        userService.saveUser(user);
        Products products = new Products( "GL100", "Nokia", 24500);
        userService.saveProducts(products);
        Shop_cart product = new Shop_cart(1, 24500);
        product.setUser(user);
        product.setProducts(products);
        user.addCart(product);
        products.addCart(product);
        Orders orders = new Orders(1,"2021-12-21", "Kiev", 24500);
        orders.setShopCart(product);
        product.addOrders(orders);
        userService.updateUser(user);
        userService.updateProducts(products);


       JDBCWorker worker = new JDBCWorker();

       String query = "SELECT * FROM user";

//        try {
//            Statement statement = worker.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                User users = new User();
//                users.setId(resultSet.getInt(1));
//                users.setName(resultSet.getString(2));
//                users.setNumber(resultSet.getString(3));
//                users.setEmail(resultSet.getString(4));
//
//                System.out.println(users);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
