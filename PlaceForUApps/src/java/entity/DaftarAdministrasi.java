/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
 *
 * @author Ika
 */
public class DaftarAdministrasi {
     public DaftarAdministrasi() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //add new Administrasi
    public void addAdministrasi(Administrasi administrasi) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(administrasi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editAdministrasi(Administrasi adm) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(adm);
            em.getTransaction().commit();
        } catch (Exception e) {//jk eerror
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    //menampilkan daftar pembayaran yang belum dikonfirmasi
   public List<Administrasi> getAdministrasi_Confirmed(long idPemilik) {
        List<Administrasi> daftarAdministrasi = new ArrayList<Administrasi>();
        int statusPembayaran = 1;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Administrasi AS o WHERE o.idPemilik=:idPemilik AND o.statusPembayaran=:statusPembayaran");
            q.setParameter("idPemilik", idPemilik);
            q.setParameter("statusPembayaran", statusPembayaran);
            daftarAdministrasi = q.getResultList();
        } finally {
            em.close();
        }
        return daftarAdministrasi;
    }

   public List<Administrasi> getAdministrasi_Unconfirmed(long idPemilik) {
        List<Administrasi> daftarAdministrasi = new ArrayList<Administrasi>();
        int statusPembayaran = 0;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Administrasi AS o WHERE o.idPemilik=:idPemilik AND o.statusPembayaran=:statusPembayaran");
            q.setParameter("idPemilik", idPemilik);
            q.setParameter("statusPembayaran", statusPembayaran);
            daftarAdministrasi = q.getResultList();

        } finally {
            em.close();
        }
        return daftarAdministrasi;
    }

   public Administrasi getAdministrasi(long id) {
        Administrasi administrasi = null;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Administrasi AS o WHERE o.id=:id");
            q.setParameter("id", id);
            administrasi = (Administrasi) q.getSingleResult();

        } finally {
            em.close();
        }
        return administrasi;
    }
   public List<Administrasi> getAllAdm_Confirmed() {
        List<Administrasi> daftarAdministrasi = new ArrayList<Administrasi>();
        int statusPembayaran = 1;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Administrasi AS o WHERE o.statusPembayaran=:statusPembayaran");
            daftarAdministrasi = q.getResultList();
            q.setParameter("statusPembayaran", statusPembayaran);
        } finally {
            em.close();
        }
        return daftarAdministrasi;
    }

}
