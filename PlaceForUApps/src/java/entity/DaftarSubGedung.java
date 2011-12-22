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
 *
 * @author Yuni
 */
public class DaftarSubGedung {

    public DaftarSubGedung() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //method utk menambah Sub Gedung baru
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

    //untuk mendaptkan dafatr dari Sub Gedung
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

    public List<SubGedung> getSubGedungFromId(Long idSubGedung) {
        SubGedung subgedung = null;
        EntityManager em = getEntityManager();
        try {
                Query q = em.createQuery("SELECT object(o)FROM SubGedung AS o WHERE o.idsubgedung=:idsubgedung");
                q.setParameter("idsubgedung", idSubGedung);
                subgedung = (SubGedung) q.getSingleResult();
            
        } finally {
            em.close();
        }
        return (List<SubGedung>) subgedung;
    }

    public List<SubGedung> getDaftarSubGedungFromGedung(Gedung gedung) {
        List<SubGedung> daftarSubGedung = new ArrayList<SubGedung>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM SubGedung AS o WHERE o.gedung=:gedung");
             q.setParameter("gedung", gedung);
            daftarSubGedung = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSubGedung;
    }

    //method utk menghapus sub gedung
     public void deleteSubGedung(Long idSubGedung) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            SubGedung subgedung;
            try {
               subgedung = em.find(SubGedung.class, idSubGedung);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + idSubGedung + " no longer exists.", enfe);
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
}
