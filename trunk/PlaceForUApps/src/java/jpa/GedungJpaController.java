/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.Gedung;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Ika
 */
public class GedungJpaController implements Serializable {

    public GedungJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gedung gedung) {
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

    public void edit(Gedung gedung) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gedung = em.merge(gedung);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = gedung.getId();
                if (findGedung(id) == null) {
                    throw new NonexistentEntityException("The gedung with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gedung gedung;
            try {
                gedung = em.getReference(Gedung.class, id);
                gedung.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gedung with id " + id + " no longer exists.", enfe);
            }
            em.remove(gedung);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gedung> findGedungEntities() {
        return findGedungEntities(true, -1, -1);
    }

    public List<Gedung> findGedungEntities(int maxResults, int firstResult) {
        return findGedungEntities(false, maxResults, firstResult);
    }

    private List<Gedung> findGedungEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gedung.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Gedung findGedung(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gedung.class, id);
        } finally {
            em.close();
        }
    }

    public int getGedungCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gedung> rt = cq.from(Gedung.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
