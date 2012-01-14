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
 * modul Manajemen Informasi Gedung, di mana fungsi tersebut dihubungkan dengan
 * kelas entitas Gedung yang merepresentasikan tabel Gedung dalam database
 * 
 * @author Ika
 */
public class DaftarGedung {

    public DaftarGedung() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * method yang digunakan untuk mengecek apakah ada nama gedung dengan
     * id pemilik yang dimasukkan.
     *
     * @param namaGedung String, idPemilik long
     * @return result boolean
     */
    public boolean cekGedungPemilik(String namaGedung, long idPemilik) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Gedung AS o WHERE o.idPemilik=:idPemilik and o.namaGedung=:namaGedung");
            q.setParameter("idPemilik", idPemilik);
            q.setParameter("namaGedung", namaGedung);
            int jumlahGedung = ((Long) q.getSingleResult()).intValue();
            if (jumlahGedung > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public boolean cekNamaGedung(String namaGedung) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Gedung AS o WHERE o.namaGedung=:namaGedung");
            q.setParameter("namaGedung", namaGedung);
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
     * method yang digunakan untuk mengecek apakah ada nama gedung dengan
     * id pemilik yang dimasukkan.
     * 
     * @return result boolean
     * @author Widiasa
     */
    public boolean cekGedung() {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Gedung AS o");
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
     * method yang digunakan untuk menambahkan data gedung
     * 
     * @param gedung Gedung
     */
    public void addGedung(Gedung gedung) {
      EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gedung);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     

    /**
     * method yang digunakan untuk mendapatkan daftar gedung
     *
     * @return daftarGedung List<Gedung>
     */
    public List<Gedung> getDaftarGedung() {
        List<Gedung> daftarGedung = new ArrayList<Gedung>();

        EntityManager em = getEntityManager();

        try {
            Query q = em.createQuery("SELECT object(o) FROM Gedung AS o");
            daftarGedung = q.getResultList();
        } finally {
            em.close();
        }
        return daftarGedung;
    }

    /**
     * method yang digunakan untuk mendapatkan daftar gedung berdasarkan id
     * pemiliknya
     *
     * @param idpemilik long
     * @return daftarGedung List<Gedung>
     */
    public List<Gedung> getDaftarGedungPemilik(long idpemilik) {
        List<Gedung> daftarGedung = new ArrayList<Gedung>();
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Gedung AS o WHERE o.idPemilik=:idpemilik");
            q.setParameter("idpemilik", idpemilik);
            daftarGedung = q.getResultList();
        } finally {
            em.close();
        }
        return daftarGedung;
    }

    /**
     * method yang digunakan untuk mendapatkan data untuk satu gedung
     * berdasarkan id gedung
     *
     * @param id long
     * @return gedung Gedung
     */
    public Gedung getGedung(long id) {
        Gedung gedung = null;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Gedung AS o WHERE o.id=:id_gedung");
            q.setParameter("id_gedung", id);
            gedung = (Gedung) q.getSingleResult();

        } finally {
            em.close();
        }
        return gedung;
    }

    /**
     * method yang digunakan untuk mendapatkan data untuk satu gedung
     * berdasarkan namaGedung
     *
     * @param namaGedung String
     * @return gedung Gedung
     */
    public Gedung getGedungFromNama(String namaGedung) {
        Gedung gedung = null;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Gedung AS o WHERE o.namagedung=:namagedung");
            q.setParameter("namagedung", namaGedung);
            gedung = (Gedung) q.getSingleResult();
        } finally {
            em.close();
        }
        return gedung;
    }

    /**
     * method yang digunakan untuk mengedit data gedung
     *
     * @param gedung Gedung
     */
    public void editGedung(Gedung gedung) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(gedung);
            em.getTransaction().commit();
        } catch (Exception e) {//jk eerror
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     * method yang digunakan untuk mengecek apakah ada data gedung yang sudah dimasukkan
     *
     * @param id Long
     * @exception NonexistenceEntityException
     */
    public void deleteGedung(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            Gedung gedung;
            try {
                gedung = em.find(Gedung.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(gedung);
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
     * method yang digunakan untuk mendapatkan data gedung berdasarkan kategori.
     *
     * @param kategoriGedung String
     * @return List<Gedung>
     */
    public List<Gedung> searchDaftarGedungFromKategori(String kategoriGedung) {
        List<Gedung> daftarGedung = new ArrayList<Gedung>();

        EntityManager em = getEntityManager();
        try {
            Query q = 
                em.createQuery("SELECT object(o) FROM Gedung AS o where o.kategoriGedung LIKE :pattern ORDER BY o.id DESC");
            q.setParameter("pattern", "%"+kategoriGedung+"%");
            daftarGedung = q.getResultList();
        } finally {
            em.close();
        }
        return daftarGedung;
    }

    /**
     * method yang digunakan untuk mendapatkan data gedung berdasarkan nama.
     *
     * @param namaGedung String
     * @return List<Gedung>
     */
    public List<Gedung> searchDaftarGedungFromNama(String namaGedung) {
        List<Gedung> daftarGedung = new ArrayList<Gedung>();
        EntityManager em = getEntityManager();
        try {
            Query q = 
                em.createQuery("SELECT object(o) FROM Gedung AS o where o.namaGedung LIKE :pattern ORDER BY o.id DESC");
            q.setParameter("pattern", "%"+namaGedung+"%");
            daftarGedung = q.getResultList();
        } finally {
            em.close();
        }
        return daftarGedung;
    }

    public List<Gedung> searchDaftarGedungFromNamaDanKategori(String namaGedung, String kategoriGedung) {
        List<Gedung> daftarGedung = new ArrayList<Gedung>();
        EntityManager em = getEntityManager();
        try {
            Query q =
                em.createQuery("SELECT object(o) FROM Gedung AS o where o.namaGedung LIKE :nama AND o.kategoriGedung LIKE :kategori ORDER BY o.id DESC");
            q.setParameter("nama", "%"+namaGedung+"%");
            q.setParameter("kategori", "%"+kategoriGedung+"%");
            daftarGedung = q.getResultList();
        } finally {
            em.close();
        }
        return daftarGedung;
    }
}
