package web.config.service;
import web.config.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers ();
    Object getUserById(int id);
    void addUser(User user);
    void removeUser(int id);
    void updateUser(User user);
}
