package dao;

import entities.User;

import java.util.List;

public interface UserDao {

    public List<User> getUsers();

    public List<User> getUsersByType(String type);

    public User checkUser(String username, String password);

}
