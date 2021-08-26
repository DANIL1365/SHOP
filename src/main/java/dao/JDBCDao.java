package dao;

import models.Orders;
import models.Products;
import models.Shop_cart;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDao implements DAO {

    String url = "jdbc:mysql://localhost:3306/shop_2";
    String username = "root";
    String password = "12345678";
    Connection connection;

    private static Logger logger = LogManager.getLogger();

    private JDBCDao() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            logger.info("Connected to database with JDBC");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static JDBCDao instance = null;

    public static JDBCDao startWorkWithDatabase() {
        if (instance == null){
            instance = new JDBCDao();
        }
        return instance;
    }

    @Override
    public User findByIdUser(int id) {
        try {
            String sql = "SELECT * FROM user";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            User user = new User();

            while (result.next()) {
                if (result.getInt("id") == id) {
                    user.setId(result.getInt("id"));
                    user.setName(result.getString("Name"));
                    user.setNumber(result.getString("Number"));
                    user.setEmail(result.getString("Email"));
                }
            }

            statement.close();
            return user;
        } catch (Throwable e) {
            logger.warn("Ошибка ");
            return null;
        }
    }

    @Override
    public boolean saveUser(User user) {
        try {
            String sql = "INSERT INTO user (Name, Number, Email) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getNumber());
            statement.setString(3, user.getEmail());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                logger.info("Строка вставлена");
            }
            statement.close();
            return true;
        } catch (Throwable e){
            logger.debug("Пользователь не был добавлен");
            return false;
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public boolean deleteUser(User user) {
        try {
            String sql = "DELETE FROM user WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                logger.info("Пользователь удален.");
                statement.close();
                return true;
            } else {
                return false;
            }

        } catch (Throwable e){
            logger.warn("Пользователь не удален");
            return false;
        }
    }

    @Override
    public Products findByIdProducts(int id) {
        try {
            String sql = "SELECT * FROM products";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            Products products = new Products();

            while (result.next()) {
                if (result.getInt("id") == id) {
                    products.setId(result.getInt("id"));
                    products.setProductName(result.getString("ProductName"));
                    products.setBrand(result.getString("Brand"));
                    products.setPrice(result.getInt("Price"));
                }
            }

            statement.close();
            return products;
        } catch (Throwable e) {
            logger.warn("Ошибка");
            return null;
        }
    }

    @Override
    public boolean saveProducts(Products products) {

        try {
            String sql = "INSERT INTO products (ProductName, Brand, Price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, products.getProductName());
            statement.setString(2, products.getBrand());
            statement.setInt(3, products.getPrice());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                logger.info("Строка вставлена");
            }
            statement.close();
            return true;
        } catch (Throwable e){
            logger.warn("Продукт не был добавлен");
            return false;
        }
    }

    @Override
    public void updateProducts(Products products) {

    }

    @Override
    public boolean deleteProducts(Products products) {
        try {
            String sql = "DELETE FROM products WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, products.getId());



            int rows = statement.executeUpdate();
            if (rows > 0) {
                logger.info("Продукт удален.");
                statement.close();
                return true;
            } else {
                return false;
            }

        } catch (Throwable e){
            logger.warn("Продукт не удален");
            return false;
        }
    }

    @Override
    public Shop_cart findShopById(int id) {
        try {
            String sql = "SELECT * FROM shop_cart";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            Shop_cart shopCart = new Shop_cart();

            while (result.next()) {
                if (result.getInt("id") == id) {
                    shopCart.setId(result.getInt("id"));
                    shopCart.setProductCount(result.getInt("ProductCount"));
                    shopCart.setPrice(result.getInt("Price"));
                }
            }

            statement.close();
            return shopCart;
        } catch (Throwable e) {
            logger.warn("Ошибка");
            return null;
        }
    }

    @Override
    public Orders findOrdersById(int id) {
        try {
            String sql = "SELECT * FROM orders";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            Orders orders = new Orders();

            while (result.next()) {
                if (result.getInt("id") == id) {
                    orders.setId(result.getInt("id"));
                    orders.setCount(result.getInt("ProductCount"));
                    orders.setCreated_At(result.getString("Created_At"));
                    orders.setDelivery_city(result.getString("Delivery_city"));
                    orders.setPrice(result.getInt("Price"));
                }
            }

            statement.close();
            return orders;
        } catch (Throwable e) {
            logger.warn("Ошибка");
            return null;
        }
    }


    @Override
    public List<User> findAllUser() {
        try {
            String sql = "SELECT * FROM user";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<User> user = new ArrayList<>();

            while (result.next()) {
                user.add(new User(result.getInt("id")
                        , result.getString("Name")
                        ,result.getString("Number")
                        ,result.getString("Email")));
            }

            statement.close();
            return user;
        } catch (Throwable e) {
            logger.warn("Ошибка");
            return null;
        }
    }

    @Override
    public List<Products> findAllProducts() {
        try {
            String sql = "SELECT * FROM products";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            List<Products> products = new ArrayList<>();

            while (result.next()) {
                products.add(new Products(result.getInt("id")
                        , result.getString("ProductName")
                        ,result.getString("Brand")
                        ,result.getInt("Price")));
            }

            statement.close();
            return products;
        } catch (Throwable e) {
            logger.warn("Ошибка");
            return null;
        }
    }
    @Override
    public boolean addProductToUsersCart(Products products, User user, Shop_cart shop_cart) {

        try {

            String sql = "INSERT INTO shop_cart ( ProductId, UserId, ProductCount, price) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.setInt(2, products.getId());
            statement.setInt(3, shop_cart.getProductCount());
            statement.setInt(4, shop_cart.getPrice());


            int rows = statement.executeUpdate();
            if (rows > 0) {
                logger.info("Строка вставлена");
            }
            statement.close();
            return true;

        } catch (Throwable e){
            logger.warn("Товар не добавлен в корзину");
            return false;
        }

    }
//
//    public boolean deleteProductFromUsersCart(Products products, User user) {
//
//        try {
//            String sql = "DELETE FROM shop_cart WHERE UserId=? AND ProductId=?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, user.getId());
//            statement.setInt(2, products.getId());
//
//            int rows = statement.executeUpdate();
//            if (rows > 0) {
//                logger.info("The row has been inserted");
//                statement.close();
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (Throwable e){
//            logger.warn("The product wasn't deleted from user's cart");
//            return false;
//        }
//
//    }

    public void finishWork(){
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        logger.info("Подключение к базе данных было закрыто");
    }

}
