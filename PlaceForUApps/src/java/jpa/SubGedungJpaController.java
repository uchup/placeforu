/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa;

import entity.SubGedung;
import jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Yuni
 */
public class SubGedungJpaController {

    public SubGedungJpaController() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SubGedung subGedung) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(subGedung);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SubGedung subGedung) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            subGedung = em.merge(subGedung);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = subGedung.getId();
                if (findSubGedung(id) == null) {
                    throw new NonexistentEntityException("The subGedung with id " + id + " no longer exists.");
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
            SubGedung subGedung;
            try {
                subGedung = em.getReference(SubGedung.class, id);
                subGedung.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The subGedung with id " + id + " no longer exists.", enfe);
            }
            em.remove(subGedung);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SubGedung> findSubGedungEntities() {
        return findSubGedungEntities(true, -1, -1);
    }

    public List<SubGedung> findSubGedungEntities(int maxResults, int firstResult) {
        return findSubGedungEntities(false, maxResults, firstResult);
    }

    private List<SubGedung> findSubGedungEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SubGedung.class));
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

    public SubGedung findSubGedung(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SubGedung.class, id);
        } finally {
            em.close();
        }
    }

    public int getSubGedungCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SubGedung> rt = cq.from(SubGedung.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
