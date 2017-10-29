/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.modelo;

import com.tentacruel.dahood.mapeobd.Gusto;
import com.tentacruel.dahood.mapeobd.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author david
 */
public class GustoDAO {
    
    /*Sesion para conectarnos a la base de datos*/
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

     /**
     * Guarda un gusto a la base de datos
     *
     * @param gusto el gusto a guardar.
     */
    public void guardarGusto(Gusto gusto) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el gusto
            session.persist(gusto); //para guardar persist

            tx.commit(); //para realizar la transaccion
        } catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //cerramos simpre la sesion
            session.close();
        }

    }
    
    
    /**
     * Regresa el gusto de la base de datos en forma de objeto
     *
     * @param nombre_gusto del usuario que se busca
     * @return salida que es el gusto con el nombre  dado
     */
    public Gusto getGusto(String nombre_gusto) {
        //Creamos una variable donde vamos a guardar el gusto solicitado
        Gusto salida = null;
        //Se inicia la sesión
        Session session = sessionFactory.openSession();
        //...la transacción a realizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();            
            String hql = "FROM Gusto WHERE nombre_gusto =: ng"; //inyectamos nickname en c
            Query query = session.createQuery(hql);
            query.setParameter("ng", nombre_gusto);
            salida = (Gusto)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //cerramos simpre la sesion
            session.close();
        }
        return salida;
    }
    
     
    /**
     * Elimina el gusto de la base de datos
     *
     * @param gusto el usuario a eliminar
     */
    public void eliminarGusto(Gusto gusto) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el usuario
            session.delete(gusto);
            tx.commit();
        } catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
    
    /**
     * Actualiza el gusto en la base de datos
     *
     * @param gusto con los nuevos valores
     */
    public void actualizarGusto(Gusto gusto) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el usuario
            session.update(gusto);

            tx.commit();
        } catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
        

}
