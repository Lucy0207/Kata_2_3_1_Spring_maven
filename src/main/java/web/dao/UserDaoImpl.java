package web.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import web.models.User;

@Repository

public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }


    public void add(User user) {

//        em.getTransaction().begin();
        entityManager.persist(user);
//        em.getTransaction().commit();
//        em.close();
    }

    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    public void edit(User user) {
        entityManager.merge(user);
    }

    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}