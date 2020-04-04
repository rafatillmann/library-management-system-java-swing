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
public class DaoAluno extends Dao{
    
    public boolean insert(Aluno a){
        try{
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean edit(Aluno a){
        try{
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean remove(Aluno a){
        try{
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public Aluno sel(int id){
        return em.find(Aluno.class, id);
    }
    
    public List<Aluno> list(){
        Query consulta = em.createQuery("select a from Aluno a");
        return consulta.getResultList();
    }
}
