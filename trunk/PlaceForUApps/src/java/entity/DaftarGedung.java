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
import jpa.exceptions.NonexistentEntityException;

/**
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
    
    //check whether any Gedung with id_pemilik & namaGedung saved in Daftar Gedung
    public boolean checkGedung(String namaGedung, long idPemilik) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Gedung AS o WHERE o.namaGedung=:namaGedung AND o.idPemilik=:idPemilik");
            q.setParameter("namaGedung", namaGedung);
            q.setParameter("idPemilik", idPemilik);
            int jumlahGedung = ((Long) q.getSingleResult()).intValue();
            if (jumlahGedung > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
    
    //add new Gedung
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

    //getting list of Gedung
    public List<Gedung> getDaftarGedung() {
        List<Gedung> daftarGedung = new ArrayList<Gedung>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Gedung AS o");
            daftarGedung = q.getResultList();
            // }

        } finally {
            em.close();
        }
        return daftarGedung;
    }
    
    public List<Gedung> getDaftarGedung(User user) {
        List<Gedung> daftarGedung = new ArrayList<Gedung>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Gedung AS o");
            daftarGedung = q.getResultList();
            // }

        } finally {
            em.close();
        }
        return daftarGedung;
    }

    public List<Gedung> getDaftarGedungPemilik(long idpemilik) {
        List<Gedung> daftarGedung = new ArrayList<Gedung>();
        int stat = 0;
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
//    public List<Gedung> getGedungfromId(Long id) {
//        Gedung gedung = null;
//        EntityManager em = getEntityManager();
//        try {
//                Query q = em.createQuery("SELECT object(o)FROM Gedung AS o WHERE o.id=:id_gedung");
//                q.setParameter("id_gedung", id);
//                gedung = (Gedung) q.getSingleResult();
//
//        } finally {
//            em.close();
//        }
//        return (List<Gedung>) gedung;
//    }
}
