/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialanimalescg102319;

import com.mycompany.parcialanimalescg102319.models.Animal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author UFG
 */
public class AnimalC {
    public static void main(String[] args) {
        
    }
    
     public static void lista(){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            TypedQuery<Animal> categorias = em.createNamedQuery("Animal.findAll",Animal.class);
            System.out.println(categorias.getResultList());
            tx.commit();
            em.close();
    }
    
    public static void uno(int id){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Animal a = em.find(Animal.class, id);
            System.out.println(a);
            tx.commit();
            em.close();
    }
    
    public static void crear(Animal a){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(a);
            tx.commit();
            em.close();
    }
    
    public static void modificar(int id, Animal a){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            //AQUI TIENE QUE IR LA LOGICA DE MODIFICAR
            System.out.println(a.getName());
            tx.commit();
            em.close();
    }
    
    public static void eliminar(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Query query = em.createNamedQuery("Animal.deleteById", Animal.class);
            int delete = query.setParameter("id", id).executeUpdate();
            System.out.println(delete);
            tx.commit();
            em.close();
    }
}
