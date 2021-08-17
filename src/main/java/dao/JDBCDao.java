package dao;

import models.Orders;
import models.Products;
import models.Shop_cart;
import models.User;
import utils.JDBCWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class JDBCDao implements WorkWithDatabase {


    @Override
    public User findByIdUser(int id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Products findByIdProducts(int id) {
        return null;
    }

    @Override
    public void save(Products products) {

    }

    @Override
    public void update(Products products) {

    }

    @Override
    public void delete(Products products) {

    }

    @Override
    public Shop_cart findShopById(int id) {
        return null;
    }

    @Override
    public Orders findOrdersById(int id) {
        return null;
    }

    JDBCWorker worker = new JDBCWorker();

    @Override
    public List<User> findAllUser() {
        List<User> allUser = new LinkedList<>();
        String query = "SELECT * FROM user";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User users = new User();
                users.setId(resultSet.getInt(1));
                users.setName(resultSet.getString(2));
                users.setNumber(resultSet.getString(3));
                users.setEmail(resultSet.getString(4));

                //System.out.println(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUser;
    }

    @Override
    public List<Products> findAllProducts() {
        return null;
    }
}
