package web.service;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

import web.dao.UserDao;
import web.models.User;


@Service
public class UserServiceImpl implements UserService {

    private UserDao userDAO;

    public void setUserDAO(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Transactional
    @Override
    public void edit(@Valid User user) {
        userDAO.edit(user);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
