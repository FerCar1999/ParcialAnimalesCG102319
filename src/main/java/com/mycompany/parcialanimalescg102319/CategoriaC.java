/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialanimalescg102319;

import com.mycompany.parcialanimalescg102319.models.Animal;
import com.mycompany.parcialanimalescg102319.models.Categoria;
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
public class CategoriaC {
    public static void main(String[] args) {
        //crear("Mamifero");
        //modificar(2, "Reptiles");
        //lista();
        eliminar(2);
        //uno(1);
    }
    
    public static void lista(){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Query categorias = em.createNativeQuery("select * from categoria", Categoria.class);
            List<Categoria> c = categorias.getResultList();
            for (Categoria categoria : c) {
                System.out.println("");
                System.out.println(categoria.getId());
                System.out.println(categoria.getName());
                System.out.println("Animales que pertenecen");
                for (Animal animal : categoria.getAnimalList()) {
                    System.out.println("------");
                    System.out.println(animal.getId());
                    System.out.println(animal.getName());
                    System.out.println(animal.getScientificName());
                }
            }
            tx.commit();
            em.close();
    }
    
    public static void uno(int id){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Categoria c = em.find(Categoria.class, id);
            System.out.println(c.getName());
            tx.commit();
            em.close();
    }
    
    public static void crear(String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Categoria c = new Categoria(name);
            em.persist(c);
            tx.commit();
            em.close();
    }
    
    public static void modificar(int id, String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Categoria c = em.find(Categoria.class, id);
            System.out.println(c.getName());
            c.setName(name);
            tx.commit();
            em.close();
    }
    
    public static void eliminar(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnimalPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Query query = em.createNamedQuery("Categoria.deleteById", Categoria.class);
            int delete = query.setParameter("id", id).executeUpdate();
            System.out.println(delete);
            tx.commit();
            em.close();
    }
}
