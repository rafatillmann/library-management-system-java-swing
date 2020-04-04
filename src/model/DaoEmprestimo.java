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
public class DaoEmprestimo extends Dao{
    public boolean insert(Emprestimo e){
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
    
    public boolean edit(Emprestimo e){
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
    
    public boolean remove(Emprestimo e){
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
    
    public Emprestimo sel(int id){
        return em.find(Emprestimo.class, id);
    }
    
    public List<Emprestimo> list(){
        Query consulta = em.createQuery("select e from Emprestimo e");
        return consulta.getResultList();
    }
}
