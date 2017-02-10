package persistence;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Repo {

    private List<User> users = new ArrayList<User>();
    private List<Product> products = new ArrayList<Product>();

    public void addUser(User user) {
        user.setId(generateUserId());
        users.add(user);
    }

    private int generateUserId() {
        if (users.size() == 0) {
            return 1;
        }
        return users.get(users.size() - 1).getId() + 1;
    }

    public int findUser(String user, String pass) throws UserNotFoundException, InvalidPasswordException {

        for (User u: users) {
            if (u.getUserName().equals(user)) {
                if (u.getPassword().equals(pass)) {
                    return u.getId();
                }
                throw new InvalidPasswordException();
            }
        }

        throw new UserNotFoundException();
    }

    public int addProduct(Product product) {
        int id = generateProductId();
        product.setId(id);
        products.add(product);
        return id;
    }

    private int generateProductId() {
        if (products.size() == 0) {
            return 1;
        }
        return products.get(products.size() - 1).getId() + 1;
    }

    public List<Product> findAllProducts() {
        List<Product> productList = new ArrayList<Product>();
        for (Product product : products) {
            productList.add(product);
        }
        return productList;
    }

    public User findUserById(int id) throws UserNotFoundException {
        for (User u: users) {
            if (u.getId() == id) {
                return u;
            }
        }
        throw new UserNotFoundException();
    }

    public Product findProductById(int productId) throws ProductNotFoundException {
        for (Product product: products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        throw new ProductNotFoundException();
    }
}
