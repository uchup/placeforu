/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Yuni
 *
 * Kelas ini berfungsi untuk mengelola fungsi yang dibutuhkan berkaitan dengan
 * modul Manajemen Informasi Gedung, di mana fungsi tersebut dihubungkan dengan
 * kelas entitas SubGedung yang merepresentasikan tabel SubGedung dalam database
 */
public class DaftarSubGedung {

    public DaftarSubGedung() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * @param idGedung long, namaSubGedung String
     * @return result boolean
     *
     * method yang digunakan untuk mengecek apakah ada nama subgedung dengan
     * id gedung yang dimasukkan.
     */
    public boolean checkSubGedung(String namaSubGedung, long idGedung) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM SubGedung AS o WHERE o.nama_sub_gedung=:namaSubGedung AND o.id_gedung=:idGedung");
            q.setParameter("nama_sub_gedung", namaSubGedung);
            q.setParameter("id_gedung", idGedung);
            int jumlahSubGedung = ((Long) q.getSingleResult()).intValue();
            if (jumlahSubGedung > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    /**
     * @return result boolean
     *
     * method yang digunakan untuk mengecek apakah ada data subgedung di database
     */
    public boolean cekSubGedung() {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM SubGedung AS o");
            int jumlahGedung = ((Long) q.getSingleResult()).intValue();
            if (jumlahGedung > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    /**
     * @return subgedung SubGedung
     * @param id Long
     *
     * method yang digunakan untuk mendapatkan data subgedung berdasarkan id
     */
    public SubGedung getSubGedung(Long id) {
        SubGedung subgedung = null;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM SubGedung AS o WHERE o.id=:id_sub_gedung");
            q.setParameter("id_sub_gedung", id);
            subgedung = (SubGedung) q.getSingleResult();
        } finally {
            em.close();
        }
        return subgedung;
    }

    /**
     * @return subgedung SubGedung
     * @param id_gedung Long
     *
     * method yang digunakan untuk mendapatkan data subgedung berdasarkan gedung
     */
    public SubGedung getSubGedungfromIDGedung(Long id_gedung) {
        SubGedung subgedung = null;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM SubGedung AS o WHERE o.id_gedung=:id_gedung");
            q.setParameter("id_gedung", id_gedung);
            subgedung = (SubGedung) q.getSingleResult();

        } finally {
            em.close();
        }
        return subgedung;
    }

    /**
     * @param subgedung SubGedung
     *
     * method yang digunakan untuk menambah data subgedung
     */
    public void addSubGedung(SubGedung subgedung) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(subgedung);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * @return List<SubGedung>
     *
     * method yang digunakan untuk mendapatkan daftar subgedung
     */
    public List<SubGedung> getDaftarSubGedung() {
        List<SubGedung> daftarSubGedung = new ArrayList<SubGedung>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM SubGedung AS o");
            daftarSubGedung = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSubGedung;
    }

    /**
     * @param id Long
     *
     * method yang digunakan untuk menghapus subgedung
     */
    public void deleteSubGedung(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            SubGedung subgedung;
            try {
                subgedung = em.find(SubGedung.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(subgedung);
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
     * @param subgedung SubGedung
     *
     * method yang digunakan untuk mengedit data subgedung
     */
    public void editSubGedung(SubGedung subgedung) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(subgedung);
            em.getTransaction().commit();
        } catch (Exception e) {//jk eerror
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     * @param id gedung long
     * @return List<SubGedung>
     *
     * method yang digunakan untuk mendapatkan daftar subgedung berdasarkan
     * id gedung
     */
    public List<SubGedung> getDaftarSubGedung(long id_gedung) {
        List<SubGedung> daftarSubGedung = new ArrayList<SubGedung>();
        int stat = 0;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM SubGedung AS o WHERE o.id_gedung=:id_gedung");
            q.setParameter("id_gedung", id_gedung);
            daftarSubGedung = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSubGedung;
    }
}
