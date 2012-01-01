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
    
    //add new Sewa
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
    //display list of Sewa by idSubGedung
   public Sewa getSewaforIdSub(long idSubGedung) {
        Sewa sewa = null;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.idSubgedung=:idSubGedung AND o.sampai=:(SELECT MAX(sampai) FROM Sewa)");
            q.setParameter("idSubGedung", idSubGedung);
            sewa = (Sewa) q.getSingleResult();

        } finally {
            em.close();
        }
        return sewa;
    }
   
   //getting sewa by its id
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
   
   //getting list of "sewa" that already confirmed
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
   
   //getting list of "sewa" that still waiting for confirmation
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
    
   //canceling sewa
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
}
