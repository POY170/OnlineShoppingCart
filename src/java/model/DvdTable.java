/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tdvdlate file, choose Tools | Tdvdlates
 * and open the tdvdlate in the editor.
 */
package model;

import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author POY
 */
public class DvdTable {
    public static List<Dvd> findAllDvd() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Dvd> dvdList = null;
        try {
            dvdList = (List<Dvd>) em.createNamedQuery("Dvd.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return dvdList;
    }    
    public static Dvd findDvdById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        Dvd dvd = null;
        try {
            dvd = em.find(Dvd.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return dvd;
    }
    //public static int updateDvd(EntityManager em, 
    //        UserTransaction utx, Dvd dvd) {
//    public static int updateDvd(Dvd dvd) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            Dvd target = em.find(Dvd.class, dvd.getId());
//            if (target == null) {
//                return 0;
//            }
//            target.setName(dvd.getName());
//            target.setSalary(dvd.getSalary());
//            em.persist(target);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            
//        }
//        finally {
//            em.close();
//            emf.close();
//        }
//        return 1;
//        
//    }
    public static int removeDvd(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
    public static int insertDvd(Dvd dvd) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, dvd.getId());
            if (target != null) {
                return 0;
            }
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
}
