package service;

import model.InvalidPasswordException;
import model.Product;
import model.User;
import model.UserNotFoundException;
import persistence.Repo;

import java.util.List;

public class UserService {

    private Repo repo;

    public UserService(Repo repo) {
        this.repo = repo;
    }

    public int logIn(String user, String pass) throws UserNotFoundException, InvalidPasswordException {
        return repo.findUser(user,pass);
    }

    public void register(String fullName, String userName, String password, String mail) {
        User user = new User(fullName, userName, password, mail);
        repo.addUser(user);
    }

    public List<Product> getUserCart(int id) throws UserNotFoundException {

        User user = repo.findUserById(id);
        return user.getCart();
    }
}