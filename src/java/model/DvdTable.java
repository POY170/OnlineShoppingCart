/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tdvdlate file, choose Tools | Tdvdlates
 * and open the tdvdlate in the editor.
 */
package model;

import java.util.Vector;
import javax.persistence.EntityManager;

/**
 *
 * @author POY
 */
public class DvdTable {
    public static Vector<Dvd> findAllDvd(EntityManager em) {
        Vector<Dvd> dvdList = null;
        try {
            dvdList = (Vector<Dvd>) em.createNamedQuery("Dvd.findAll").getResultList();
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        finally {
            em.close();
        }
        return dvdList;
    }
    public static Dvd findDvdById(EntityManager em, int id) {
        Dvd dvd = null;
        try {
            dvd = em.find(Dvd.class, id);
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        finally {
            em.close();
        }
        return dvd;
    }
    //public static int updateDvd(EntityManager em, 
    //        UserTransaction utx, Dvd dvd) {
    public static int updateDvd(EntityManager em, Dvd dvd) {
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, dvd.getId());
            if (target == null) {
                return 0;
            }
            target.setQty(dvd.getQty());
//            target.setSalary(dvd.getSalary());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
        }
        return 1;
        
    }
    public static int removeDvd(EntityManager em, int id) {
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
        }
        return 1;
    }
    
    public static int insertDvd(EntityManager em, Dvd dvd) {
        try {
            em.getTransaction().begin();
            Dvd target = em.find(Dvd.class, dvd.getId());
            if (target != null) {
                return 0;
            }
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
        }
        return 1;
    }
}
