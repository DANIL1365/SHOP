package utils;

import models.Products;
import models.Shop_cart;
import models.User;
import services.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = new User("Дима", "0968904760", "Dima@gmail");
        userService.saveUser(user);
        Products products = new Products( "GL100", "Nokia", 24500);
        userService.saveProducts(products);
        Shop_cart product = new Shop_cart(27834);
        product.setUser(user);
        product.setProducts(products);
        user.addCart(product);
        products.addCart(product);
        userService.updateUser(user);
        userService.updateProducts(products);
        user.setName("Максим");
        userService.updateUser(user);
        //userService.deleteUser(user);
    }
}
