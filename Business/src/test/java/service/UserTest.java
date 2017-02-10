package service;

import model.InvalidPasswordException;
import model.User;
import model.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;
import persistence.Repo;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        Repo repo = new Repo();
        repo.addUser(new User("Juan Perez", "user1", "password", "juan_perez@gmail.com"));
        userService = new UserService(repo);
    }

    @Test
    public void registerTest() throws UserNotFoundException, InvalidPasswordException {
        userService.register("Miguel Sanchez", "user2", "password", "miguel_sanchez@gmail.com");
        int id = userService.logIn("user2", "password");
        assertEquals(id, 2);
    }

    @Test
    public void logInTest() throws UserNotFoundException, InvalidPasswordException {
        int id = userService.logIn("user1", "password");
        assertEquals(id, 1);
    }

    @Test (expected = UserNotFoundException.class)
    public void logInNotFoundUserTest() throws UserNotFoundException, InvalidPasswordException {
        int id = userService.logIn("user2", "password");
    }

    @Test (expected = InvalidPasswordException.class)
    public void logInWrongPasswordTest() throws UserNotFoundException, InvalidPasswordException {
        int id = userService.logIn("user1", "wrong password");
    }



}
