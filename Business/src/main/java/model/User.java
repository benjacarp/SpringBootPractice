package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private String password;
    private int id;
    private List<Product> cart = new ArrayList<Product>();

    public User(String fullName, String user, String password, String mail) {
        this.userName = user;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public void addProductToCart(Product product) {
        cart.add(product);
    }
}
