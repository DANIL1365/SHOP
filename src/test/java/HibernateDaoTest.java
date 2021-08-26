import dao.DAO;
import dao.HibernateDao;
import models.Orders;
import models.Products;
import models.Shop_cart;
import models.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class HibernateDaoTest {

    DAO hibernateDao = HibernateDao.startWorkWithDatabase();

    @Test
    public void findAllUser() {


        //создаем список expected и заполняем его данными нашего метода
        List<User> expected = hibernateDao.findAllUser();

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предполагаем метод должен вернуть
        List<User> actual = hibernateDao.findAllUser();

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllUsers_NO_NULL() {
        //добавим проверку на null
        List<User> expected = hibernateDao.findAllUser();
        Assert.assertNotNull(expected);
    }

    @Test
    public void findByIdUser() {
        //создаем тестовые данные
        User user = new User(1,"Антон", "0984567821", "1@mail.ua");


        //создаем список expected и заполняем его данными нашего метода
        User idUser = hibernateDao.findByIdUser(1);
        List<User> expected = new ArrayList<>();
        expected.add(idUser);

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предполагаем метод должен вернуть
        List<User> actual = new ArrayList<>();
        actual.add(user);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findByIdUser_NO_NULL() {
        //добавим проверку на null
        User idUser = hibernateDao.findByIdUser(1);
        List<User> expected = new ArrayList<>();
        expected.add(idUser);
        Assert.assertNotNull(expected);
    }

    @Test
    public void saveUser(){

        User user = new User(6,"Nik","09452895","Nik@mail.dr");
        Assert.assertTrue(hibernateDao.saveUser(user));
    }
//    @Test
//    public void deleteUser(){
//      //  User user = new User(6,"Nik","09452895","Nik@mail.dr");
//        Assert.assertTrue(jdbcDao.deleteUser(jdbcDao.findByIdUser(90)));
//    }


    @Test
    public void findAllProducts() {

        //создаем список expected и заполняем его данными нашего метода

        List<Products> expected = hibernateDao.findAllProducts();

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предполагаем метод должен вернуть
        List<Products> actual = hibernateDao.findAllProducts();


        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllProducts_NO_NULL() {
        //добавим проверку на null
        List<Products> expected = hibernateDao.findAllProducts();
        Assert.assertNotNull(expected);
    }

    @Test
    public void findByIdProducts() {
        //создаем тестовые данные
        Products products = new Products(1,"iPhone X", "Apple", 76000);

        //создаем список expected и заполняем его данными нашего метода
        Products idProducts = hibernateDao.findByIdProducts(1);
        List<Products> expected = new ArrayList<>();
        expected.add(idProducts);

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предполагаем метод должен вернуть
        List<Products> actual = new ArrayList<>();
        actual.add(products);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findByIdProducts_NO_NULL() {
        //добавим проверку на null
        Products idProducts = hibernateDao.findByIdProducts(1);
        List<Products> expected = new ArrayList<>();
        expected.add(idProducts);
        Assert.assertNotNull(expected);
    }

    @Test
    public void saveProducts(){

        Products products = new Products(90,"A34G60","Mazeti",300000);
        Assert.assertTrue(hibernateDao.saveProducts(products));
    }
//    @Test
//    public void deleteProducts(){
//      //Products products = new Products(6,"A34G60","Meazy",30000);
//        Assert.assertTrue(shop.deleteProducts(shop.findByIdProducts()));
//    }

    @Test
    public void findShopById() {
        //создаем тестовые данные
        Shop_cart shop_cart = new Shop_cart(2, 46000);

        //создаем список expected и заполняем его данными нашего метода
        Shop_cart idShop = hibernateDao.findShopById(1);
        List<Shop_cart> expected = new ArrayList<>();
        expected.add(idShop);

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предполагаем метод должен вернуть
        List<Shop_cart> actual = new ArrayList<>();
        actual.add(shop_cart);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findShopById_NO_NULL() {
        //добавим проверку на null
        Shop_cart idShop = hibernateDao.findShopById(1);
        List<Shop_cart> expected = new ArrayList<>();
        expected.add(idShop);
        Assert.assertNotNull(expected);
    }

    @Test
    public void findOrdersById() {
        //создаем тестовые данные
        Orders orders = new Orders( 1, 2,"2021-08-08", "Киев", 46000);

        //создаем список expected и заполняем его данными нашего метода
        Orders idOrders = hibernateDao.findOrdersById(1);
        List<Orders> expected = new ArrayList<>();
        expected.add(idOrders);

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предполагаем метод должен вернуть
        List<Orders> actual = new ArrayList<>();
        actual.add(orders);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findOrdersById_NO_NULL() {
        //добавим проверку на null
        Orders idOrders = hibernateDao.findOrdersById(1);
        List<Orders> expected = new ArrayList<>();
        expected.add(idOrders);
        Assert.assertNotNull(expected);
    }}
