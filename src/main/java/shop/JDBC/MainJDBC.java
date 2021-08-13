package shop.JDBC;

import java.sql.*;

public class MainJDBC {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "SELECT * FROM user";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setNumber(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));

                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




