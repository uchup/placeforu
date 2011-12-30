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
   public List<Sewa> getDaftarSewaPenyewa(long idPenyewa) {
        List<Sewa> daftarSewa = new ArrayList<Sewa>();
        int stat = 0;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Sewa AS o WHERE o.idPenyewa=:idPenyewa");
            q.setParameter("idPenyewa", idPenyewa);
            daftarSewa = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSewa;
    }
}
