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
    
    //check whether any Gedung with idGedung & namaSubGedung saved in Daftar Gedung before
    public boolean checkSubGedung(String namaSubGedung, long idGedung) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM SubGedung AS o WHERE o.nama_sub_gedung=:namaSubGedung AND o.id_gedung=:idGedung");
            q.setParameter("nama_sub_gedung", namaSubGedung);
            q.setParameter("id_gedung", idGedung);
            int jumlahSubGedung = ((Long) q.getSingleResult()).intValue();
            if (jumlahSubGedung > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }
    
    public SubGedung getSubGedung(Long id) {
        SubGedung subgedung= null;
        EntityManager em = getEntityManager();
        try {
                Query q = em.createQuery("SELECT object(o) FROM SubGedung AS o WHERE o.id=:id_sub_gedung");
                q.setParameter("id_sub_gedung", id);
                subgedung = (SubGedung) q.getSingleResult();
            
        } finally {
            em.close();
        }
        return subgedung;
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

    public List<SubGedung> getSubGedungfromId(int id) {
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
     public void editSubGedung(SubGedung subgedung) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try { //jik tdk ada error
            em.merge(subgedung);
            em.getTransaction().commit();
        } catch (Exception e) {//jk eerror
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }







       public List<SubGedung> getDaftarSubGedung(long id_gedung) {
        List<SubGedung> daftarSubGedung = new ArrayList<SubGedung>();
        int stat = 0;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM SubGedung AS o WHERE o.id_gedung=:id_gedung");
            q.setParameter("id_gedung", id_gedung);
            daftarSubGedung = q.getResultList();

        } finally {
            em.close();
        }
        return daftarSubGedung;
    }

    


}
