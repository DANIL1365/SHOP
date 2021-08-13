package com.shop;

import java.sql.*;

public class MainJDBC {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/shop_2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Connection connection = null;
            Statement statement = null;


            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Creating statement...");
            statement = connection.createStatement();


            String sql = "SELECT * FROM products";



            Boolean isRetrieved = statement.execute(sql);

            System.out.println("Данные получены: " + isRetrieved);

            System.out.println("Отображение полученных данных:");
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("ProductName");
                String brand = resultSet.getString("Brand");
                int price = resultSet.getInt("Price");

                System.out.println("id: " + id);
                System.out.println("ProductName: " + productName);
                System.out.println("Brand: " + brand);
                System.out.println("Price: " + price);
                System.out.println("\n===================\n");
            }

            System.out.println("Closing connection and releasing resources...");

            try {
                resultSet.close();
                statement.close();
                connection.close();
            }finally {
                if(statement !=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }
        }
    }
