/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Clientes;
import classes.Empresa;
import classes.Sequences;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import util.HibernateUtil;

/**
 *
 * @author Dionatan
 */
public abstract class CustomDAO<T> {
    protected Session sessao;
       
    /**
     * Realiza o Insert no banco de dados
     * @param obj Object
     * @return Boolean
     */
    public Boolean Insert(T obj){
        Boolean vReturn = true;
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();        
        
        try{
            sessao.save(obj);                        
            transaction.commit();
        } catch (Exception ex){
            
            transaction.rollback();
            vReturn = false;
        } finally {
            if(sessao !=null && sessao.isOpen()) {
                sessao.close();
                sessao=null;
            }
        }
        
        return vReturn;
    }
    
    /**
     * Realiza o update no banco de dados
     * @param obj Object
     * @return Boolean
     */
    //public abstract Boolean Update(T obj);
    public Boolean Update(T obj){
        Boolean vReturn = true;      
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();                
        try{                        
            sessao.update(obj);                        
            transaction.commit();
        } catch (Exception ex){            
            transaction.rollback();
            vReturn = false;
        } finally {
            if(sessao !=null && sessao.isOpen()) {
                sessao.close();
                sessao=null;
            }
        }
        
        return vReturn;
    }
    /**
     * Realiza o delete no banco de dados
     * @param obj Object
     * @return Boolean
     */
    public Boolean Delete(T obj){
        Boolean vReturn = true;
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();        
        
        try{
            sessao.delete(obj);                        
            transaction.commit();
        } catch (Exception ex){
            
            transaction.rollback();
            vReturn = false;
        } finally {
            if(sessao !=null && sessao.isOpen()) {
                sessao.close();
                sessao=null;
            }
        }
        
        return vReturn;
    }
    
    /**
     * Realiza Consulta SQL
     * @param sql SQL do BD
     * @return  Lista de Object´s
     */
    public List<T> consultaSQL(String sql) {        
        List<T> returnList=null;
        //Transaction transaction = sessao.beginTransaction();        
        Query query    = null;
        try{                      
           sessao = HibernateUtil.getSessionFactory().openSession();
           query = sessao.createQuery(sql);     
            
           returnList = query.list();
          // transaction.commit();
        }catch (HibernateException e) {                 
          //transaction.rollback();
          e.printStackTrace(); 
        }finally {
            if(sessao !=null && sessao.isOpen()) {
                sessao.close();
                sessao=null;
            }
        }
       return returnList;
    }
}
