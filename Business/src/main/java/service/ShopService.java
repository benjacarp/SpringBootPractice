package service;

import model.Product;
import model.ProductNotFoundException;
import model.User;
import model.UserNotFoundException;
import persistence.Repo;

public class ShopService {
    private final Repo repo;

    public ShopService(Repo repo) {
        this.repo = repo;
    }

    public void addProductToCart(int userId, int productId, int quantity) throws UserNotFoundException, ProductNotFoundException {
        User user = repo.findUserById(userId);
        Product product = repo.findProductById(productId);
        user.addProductToCart(product);
    }
}
