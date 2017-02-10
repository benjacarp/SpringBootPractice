package service;

import model.InvalidPasswordException;
import model.ProductNotFoundException;
import model.User;
import model.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;
import persistence.Repo;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest {

    private ShopService shopService;
    private UserService userService;
    private int defaultProductId;
    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        Repo repo = new Repo();
        repo.addUser(new User("Juan Perez", "user1", "password", "juan_perez@gmail.com"));
        shopService = new ShopService(repo);
        userService = new UserService(repo);
        productService = new ProductService(repo);
        defaultProductId = productService.addProduct("name", 250.00);
    }

    @Test
    public void addItemToCartTest() throws UserNotFoundException, InvalidPasswordException, ProductNotFoundException {
        int id = userService.logIn("user1","password");
        shopService.addProductToCart(id, defaultProductId, 1);
        int cartSize = userService.getUserCart(id).size();
        assertEquals(1,cartSize);
    }
}