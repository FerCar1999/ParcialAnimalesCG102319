/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialanimalescg102319;

import com.mycompany.parcialanimalescg102319.models.Animal;
import com.mycompany.parcialanimalescg102319.models.Categoria;
import java.util.Arrays;
import java.util.List;
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
        //select todos
        //lista();
        //select uno especifico
        //uno(1);
        //crear
        /*
        Animal crearAnimal=new Animal();
        crearAnimal.setName("Test");
        crearAnimal.setScientificName("Test");
        crearAnimal.setFamily("Test");
        crearAnimal.setIdCategoria(unoCat(1));
        crear(crearAnimal);
        */
        //modificar(1);
        eliminar(2);
        lista();
        
    }
    
     public static void lista(){
            System.out.println("Lista de animales");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Query categorias = em.createNativeQuery("select * from animal", Animal.class);
            List<Animal> a=categorias.getResultList();
            for(Animal an:a){
                System.out.println("");
                System.out.println(an.getId());
                System.out.println(an.getName());
                System.out.println(an.getScientificName());
                System.out.println(an.getFamily());
                System.out.println(an.getIdCategoria().getName());
            }
            tx.commit();
            em.close();
    }
     public static Categoria unoCat(int id){
       
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Categoria c = em.find(Categoria.class, id);
           
            tx.commit();
            em.close();
            return c;
    }
    
    public static void uno(int id){
        System.out.println("Animal especifico:");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Animal a = em.find(Animal.class, id);
            System.out.println(a.getId());
            System.out.println(a.getName());
            System.out.println(a.getScientificName());
            System.out.println(a.getFamily());
            System.out.println(a.getIdCategoria().getName());
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
    
    public static void modificar(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Animal a=em.find(Animal.class, id);
            a.setName("Test");
            a.setScientificName("Test");
            a.setFamily("Test");
            a.setIdCategoria(unoCat(1));
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
