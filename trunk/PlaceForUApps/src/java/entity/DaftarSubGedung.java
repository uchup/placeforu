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

    public List<SubGedung> getSubGedungfromId(Long id) {
        SubGedung subgedung = null;
        EntityManager em = getEntityManager();
        try {
                Query q = em.createQuery("SELECT object(o)FROM SubGedung AS o WHERE o.id=:id_sub_gedung");
                q.setParameter("id_sub_gedung", id);
                subgedung = (SubGedung) q.getSingleResult();
            
        } finally {
            em.close();
        }
        return (List<SubGedung>) subgedung;
    }

    //method utk menghapus sub gedung
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
}
