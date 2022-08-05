package web.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import web.models.User;

@Repository

public class UserDao {
    private final EntityManagerFactory emf;
    @PersistenceContext
    private  EntityManager entityManager;

    public UserDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }

    public void add(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
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