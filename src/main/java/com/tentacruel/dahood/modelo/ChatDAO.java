/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.modelo;

import com.tentacruel.dahood.mapeo.Amigos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author orlando
 */
public class ChatDAO {
    
    private SessionFactory sessionFactory;
    
    /**
     * Inicialisamos la sesion a la base de datos.
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    public List<Amigos> GetAmigos(int usuario){
       
        List<Amigos> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //Checar que amigos este bien si no cambiarlo por conocer.
            String hql = "From Amigos where usuario = :usuario";
            Query query = session.createQuery(hql);
            query.setParameter("usuario", usuario);
            result = (List<Amigos>)query.list();
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return result;
    }
    
}
