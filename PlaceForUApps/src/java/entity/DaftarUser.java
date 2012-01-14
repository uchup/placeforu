/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Kelas ini berfungsi untuk mengelola fungsi yang dibutuhkan berkaitan dengan
 * modul Manajemen User, di mana fungsi tersebut dihubungkan dengan kelas entitas
 * User yang merepresentasikan tabel User dalam database
 *
 * @author Widiasa
 */
public class DaftarUser {

    public DaftarUser() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * method yang digunakan untuk mengecek keberadaan pengguna
     * pada tabel User berdasarkan parameter username dan password
     *
     * @param username String
     * @param password String
     */
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

    /**
     * method yang digunakan untuk mengecek keberadaan pengguna
     * pada tabel User berdasarkan parameter username
     *
     * @param username String
     */
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

    /**
     * method untuk mengambil data satu pengguna pada tabel User
     * berdasarkan parameter username dan password
     *
     * @param username String, password String
     * @return User entity
     */
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

    /**
     * method untuk mengambil data satu pengguna pada tabel User
     * berdasarkan parameter username
     *
     * @param username String
     * @return User entity
     */
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

    /**
     * method untuk mengambil data satu pengguna pada tabel User
     * berdasarkan parameter id
     *
     * @param id long
     * @return User entity
     */
    public User getUserFromId(long id) {
        User user = null;
        EntityManager em = getEntityManager();
        try {

            Query q = em.createQuery("SELECT object(o) FROM User AS o WHERE o.id=:id");
            q.setParameter("id", id);
            user = (User) q.getSingleResult();

        } finally {
            em.close();
        }
        return user;
    }

    /**
     * method untuk mengubah data pengguna yang sudah ada pada tabel users
     *
     * @param user User entity
     */
    public void editUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {//jk eerror
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     * method untuk menambahkan data pengguna baru ke dalam tabel users
     *
     * @param user User entity
     */
    public void addUser(User user) {
        EntityManager em = getEntityManager();
        boolean hasilCheck1 = checkUser(user.getUsername());
        if (!hasilCheck1) {
            em.getTransaction().begin();
            try {
                em.persist(user);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        } else {
            try {
                throw new MyException("Username telah ada");
            } catch (MyException ex) {
                Logger.getLogger(DaftarUser.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}

    /**
     * @return List<User>
     *
     * method untuk menampilkan list/daftar pengguna dari tabel User
     */
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM User AS o");
            users = q.getResultList();

        } finally {
            em.close();
        }
        return users;
    }

    /**
     * method untuk menampilkan list/daftar username pengguna dari tabel User
     *
     * @param username String
     * @return List<User>
     */
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

    /**
     * method untuk menghapus satu data pengguna di tabel User
     *
     * @param id Long
     */
    public void deleteUser(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            User user;
            try {
                user = em.find(User.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * method untuk menampilkan list/daftar pengguna yang belum
     * dikonfirmasi dari tabel User
     *
     * @return List<User>
     */
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
