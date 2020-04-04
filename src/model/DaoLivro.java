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
public class DaoLivro extends Dao{
    public boolean insert(Livro l){
        try{
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean edit(Livro l){
        try{
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public boolean remove(Livro l){
        try{
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
            return true;
        }catch(PersistenceException e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public Livro sel(int id){
        return em.find(Livro.class, id);
    }
    
    public List<Livro> list(){
        Query consulta = em.createQuery("select l from Livro l");
        return consulta.getResultList();
    }
}
