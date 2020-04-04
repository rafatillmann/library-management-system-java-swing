/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 *
 * @author aluno
 */
public class DaoEditora extends Dao{
    public boolean insert(Editora e){
        try{
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean edit(Editora e){
        try{
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean remove(Editora e){
        try{
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException ex){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public Editora sel(int id){
        return em.find(Editora.class, id);
    }
    
    public List<Editora> list(){
        Query consulta = em.createQuery("select e from Editora e");
        return consulta.getResultList();
    }
}
