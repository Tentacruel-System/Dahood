/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.tentacruel.dahood.modelo;

import com.tentacruel.dahood.mapeobd.Amigos;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
     * Inicializamos la sesion a la base de datos.
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    public List<Amigos> getAmigos(int user){
        
        List<Amigos> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //Checar que amigos este bien si no cambiarlo por conocer.
            String hql = "FROM Amigos where amigo = :user";//*inner join conocer on usuario.id_usuario = conocer.usuario where usuario =:id"
            Query query = session.createQuery(hql);
            query.setParameter("user",user);
            //query.setParameter("id", usuario);
            
            result = query.list();
            tx.commit();
 
        }
        catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        }
        finally{
            session.close();
        }
        
        return result;
    }
    
    
    public List<Amigos> getAmigosName(int usuario){
        
        List<Amigos> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //Checar que amigos este bien si no cambiarlo por conocer.
            String hql = "FROM Usuario where usuario = :usuario";
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
