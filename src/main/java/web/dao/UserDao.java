package web.dao;

import java.util.List;

import web.models.User;

public interface UserDao {
    List<User> getAllUsers();

    void add(User user);

    void delete(int id);

    void edit(User user);

    User getById(int id);
}
