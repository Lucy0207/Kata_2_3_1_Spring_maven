package web.service;

import java.util.List;

import javax.validation.Valid;

import web.models.User;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void delete(int id);
    void edit(@Valid User user);
    User getById(int id);
}

