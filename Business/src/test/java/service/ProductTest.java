package service;

import org.junit.Before;
import org.junit.Test;
import persistence.Repo;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        Repo repo = new Repo();
        productService = new ProductService(repo);
    }

    @Test
    public void addProductTest() {
        productService.addProduct("Nombre", 100.00);
        int id = productService.addProduct("Nombre 2", 150.00);
        assertEquals(2,id);
        assertEquals(2, productService.findAllProducts().size());
    }

}
