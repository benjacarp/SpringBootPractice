package service;

import model.Product;
import persistence.Repo;

import java.util.List;

public class ProductService {

    private final Repo repo;

    public ProductService(Repo repo) {
        this.repo = repo;
    }

    public int addProduct(String name, double price) {
        return repo.addProduct(new Product(name, price));
    }

    public List<Product> findAllProducts() {
        return repo.findAllProducts();
    }
}
