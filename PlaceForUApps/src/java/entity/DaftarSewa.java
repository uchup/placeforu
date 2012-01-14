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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Kelas ini berfungsi untuk mengelola fungsi yang dibutuhkan berkaitan dengan
 * modul Manajemen Penyewaan, di mana fungsi tersebut dihubungkan dengan kelas entitas
 * Sewa yang merepresentasikan tabel Sewa dalam database
 *
 * @author Ika
 */
public class DaftarSewa {

    public DaftarSewa() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * method yang digunakan untuk memasukkan data penyewaan baru
     *
     * @param sewa Sewa
     */
    public void addSewa(Sewa sewa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sewa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * method yang digunakan untuk mendapatkan objek Sewa agar user
     * mendapatkan detail suatu data penyewaan berdasarkan idSewa dari data
     * penyewaan tersebut.
     *
     * @param  idSewa long
     * @return Sewa
     */
    public Sewa getSewaFromId(long idSewa) {
        Sewa sewa = null;
        EntityManager em = getEntityManager();
        try {

            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.idSewa=:idSewa");
            q.setParameter("idSewa", idSewa);
            sewa = (Sewa) q.getSingleResult();

        } finally {
            em.close();
        }
        return sewa;
    }

    /**
     * method yang digunakan untuk mendapatkan daftar penyewaan yang belum di
     * konfirmasi berdasarkan id penyewa.@param idPenyewa long
     *
     * @return daftarSewa List<Sewa>
     */
    public List<Sewa> getDaftarSewaPenyewa_Unconfirmed(long idPenyewa) {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();
        int status = 0;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.idPenyewa=:idPenyewa AND o.status=:status");
            q.setParameter("idPenyewa", idPenyewa);
            q.setParameter("status", status);
            daftarSewa = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSewa;
    }

    /**
     * method yang digunakan untuk mendapatkan daftar penyewaan yang sudah di
     * konfirmasi berdasarkan id penyewa.
     * 
     * @param idPenyewa long
     * @return daftarSewa List<Sewa>
     */
    public List<Sewa> getDaftarSewaPenyewa_Confirmed(long idPenyewa) {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();
        int stat = 1;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.idPenyewa=:idPenyewa AND o.status=:stat");
            q.setParameter("idPenyewa", idPenyewa);
            q.setParameter("stat", stat);
            daftarSewa = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSewa;
    }

    /**
     * method yang digunakan untuk mendapatkan daftar penyewaan yang
     * belum lunas dibayar berdasarkan id penyewa.
     *
     * @param idPenyewa long
     * @return daftarSewa List<Sewa>
     */
    public List<Sewa> getUtangPenyewa(long idPenyewa) {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();
        int sisaBayar = 1;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.idPenyewa=:idPenyewa AND o.sisaBayar>=:sisaBayar");
            q.setParameter("idPenyewa", idPenyewa);
            q.setParameter("sisaBayar", sisaBayar);
            daftarSewa = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSewa;
    }

    /**
     * method yang digunakan untuk mendapatkan daftar penyewaan yang belum di
     * konfirmasi berdasarkan id pemilik.
     *
     * @param idPemilik long
     * @return daftarSewa List<Sewa>
     */
    public List<Sewa> getDaftarSewaPemilik_Unconfirmed(long idPemilik) {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();
        int status = 0;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.idPemilik=:idPemilik AND o.status=:status");
            q.setParameter("idPemilik", idPemilik);
            q.setParameter("status", status);
            daftarSewa = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSewa;
    }

    /**
     * method yang digunakan untuk mendapatkan daftar penyewaan yang sudah di
     * konfirmasi berdasarkan id pemilik.
     *
     * @param idPemilik long
     * @return daftarSewa List<Sewa>
     */
    public List<Sewa> getDaftarSewaPemilik_Confirmed(long idPemilik) {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();
        int stat = 1;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.idPemilik=:idPemilik AND o.status=:stat");
            q.setParameter("idPemilik", idPemilik);
            q.setParameter("stat", stat);
            daftarSewa = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSewa;
    }

    /**
     * method yang digunakan untuk mendapatkan daftar penyewaan yang sudah di
     * konfirmasi
     *
     * @return daftarSewa List<Sewa>
     */
    public List<Sewa> getAllSewa_Confirmed() {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();
        int stat = 1;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.status=:stat");
            q.setParameter("stat", stat);
            daftarSewa = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSewa;
    }

    /**
     * method yang digunakan untuk mendapatkan daftar penyewaan yang belum di
     * konfirmasi
     *
     * @return daftarSewa List<Sewa>
     */
    public List<Sewa> getAllSewa_Unconfirmed() {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();
        int status = 0;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.status=:status");
            q.setParameter("status", status);
            daftarSewa = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSewa;
    }

    /**
     * method yang digunakan untuk memberi konfirmasi pada penyewaan yang belum
     * dikonfirmasi
     *
     * @param sewa Sewa
     */
    public void konfirmSewa(Sewa sewa) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(sewa);
            em.getTransaction().commit();
        } catch (Exception e) {//jk eerror
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     * method yang digunakan untuk membatalkan penyewaan
     *
     * @param id Long
     * @throws NonexistentEntityException
     */
    public void cancelSewa(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Sewa sewa;
            try {
                sewa = em.find(Sewa.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Penyewaan dengan " + id + " sudah tidak ada.", enfe);
            }
            em.remove(sewa);
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
     * method yang digunakan untuk menghapus penyewaan
     *
     * @param id Long
     * @throws NonexistentEntityException
     */
    public void removeSewa(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Sewa sewa;
            try {
                sewa = em.find(Sewa.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Penyewaan dengan " + id + " sudah tidak ada.", enfe);
            }
            em.remove(sewa);
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
     * method yang digunakan untuk mengubah penyewaan
     *
     * @param sewa Sewa
     */
    public void editSewa(Sewa sewa) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(sewa);
            em.getTransaction().commit();
        } catch (Exception e) {//jk eerror
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
