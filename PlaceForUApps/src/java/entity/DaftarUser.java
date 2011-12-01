/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Noval54
 */
public class DaftarUser {

    public DaftarUser() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean check(String username, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM User AS o WHERE o.username=:usr AND o.password=:pswd");
            q.setParameter("usr", username);
            q.setParameter("pswd", password);
            int jumlahUser = ((Long) q.getSingleResult()).intValue();
            if (jumlahUser > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public boolean checkUser(String username) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM User AS o WHERE o.username=:usr");
            q.setParameter("usr", username);
            int jumlahUser = ((Long) q.getSingleResult()).intValue();
            if (jumlahUser > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public User getUser(String username, String password) {
        User user = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(username, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM User AS o WHERE o.username=:usr AND o.password=:pswd");
                q.setParameter("usr", username);
                q.setParameter("pswd", password);
                user = (User) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return user;
    }

    //   method untuk mengambil satu baris user berdasarkan parameter username

    public User getUserFromName(String username) {
        User user = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.checkUser(username);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM User AS o WHERE o.username=:usr");
                q.setParameter("usr", username);
                user = (User) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return user;
    }

    //method untuk mengganti nilai atribut pada baris yang sudah ada pada tabel users
     public void editUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e){//jk eerror
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void addUser(User user) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        int stat = 1;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM User AS o WHERE o.status=:stat"); 
            q.setParameter("stat", stat);
            users = q.getResultList();

        } finally {
            em.close();
        }
        return users;
    }
    // get username list
    public List<User> getUsername(String username) {
        List<User> users = new ArrayList<User>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM User AS o WHERE o.username=:usr");
            q.setParameter("usr", username);
            users = q.getResultList();

        } finally {
            em.close();
        }
        return users;
    }

    public void getUsers(User user) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    //remove a user
    public void removeUser(User user) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
          //  User user;
            try {
                user = em.getReference(User.class, user);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("User sudah tidak ada", enfe);
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> getUnconfirmedUsers() {
       List<User> users = new ArrayList<User>();
        int stat = 0;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM User AS o WHERE o.status=:stat"); 
            q.setParameter("stat", stat);
            users = q.getResultList();

        } finally {
            em.close();
        }
        return users;
    }

}
