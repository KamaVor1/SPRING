package web.config.dao;

import web.config.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserById(int id);
    void updateUser(User user);
    void removeUser(int id);
    void addUser(User user);
}
