/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tcartlate file, choose Tools | Tcartlates
 * and open the tcartlate in the editor.
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
public class CartTable {
    public static List<Cart> findAllCart() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Cart> cartList = null;
        try {
            cartList = (List<Cart>) em.createNamedQuery("Cart.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
            emf.close();
        }
        return cartList;
    }    
    public static Cart findCartById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        Cart cart = null;
        try {
            cart = em.find(Cart.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return cart;
    }
    //public static int updateCart(EntityManager em, 
    //        UserTransaction utx, Cart dvd) {
//    public static int updateCart(Cart cart) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            Cart target = em.find(Cart.class, cart.getId());
//            if (target == null) {
//                return 0;
//            }
//            target.setName(cart.getName());
//            target.setSalary(cart.getSalary());
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
    public static int removeCart(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cart target = em.find(Cart.class, id);
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
    
    public static int insertCart(Cart cart) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cart target = em.find(Cart.class, cart.getId());
            if (target != null) {
                return 0;
            }
            em.persist(cart);
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
