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
            //int jumlahGedung = ((Long) q.getSingleResult()).intValue();
            //if (jumlahGedung < 0) {
            // String pesan = "tidak ada daftar gedung tersimpan";
            // daftarGedung = (List<Gedung>) q.setParameter("pesan", pesan);
            // } else {
            daftarGedung = q.getResultList();
            // }

        } finally {
            em.close();
        }
        return daftarGedung;
    }

    public Gedung getGedung(Long id) {
        Gedung gedung= null;
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
