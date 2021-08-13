package shop.JDBC;

import java.sql.*;

public class DBWorker {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/shop_2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

    private Connection connection;

    public DBWorker() {
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
