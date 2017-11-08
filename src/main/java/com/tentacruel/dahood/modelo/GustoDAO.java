/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.modelo;

import com.tentacruel.dahood.mapeobd.Amigos;
import com.tentacruel.dahood.mapeobd.Gusto;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.mapeobd.UsuarioGusto;
import java.util.List;
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
            String hql = "FROM Gusto WHERE nombre_gusto = :ng"; 
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
        
    //Devuele una lista con los Id's de los gustos del usuario dado
    public List<UsuarioGusto> getGustoId(int usuario){
       
        List<UsuarioGusto> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();            
            String hql = "from UsuarioGusto where id_usuario = :usuario";
            Query query = session.createQuery(hql);
            query.setParameter("usuario", usuario);
            result = (List<UsuarioGusto>)query.list();
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
    
    //Regresan una lista con el nombre de los gustos dado el Id del gusto
    public List<Gusto> getGustoNombre(int gusto){
       
        List<Gusto> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();            
            String hql = "From Gusto where id_gusto = :gusto";
            Query query = session.createQuery(hql);
            query.setParameter("gusto", gusto);
            result = (List<Gusto>)query.list();
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
    
    //Regresa una lista de Ids de los gustos con coincidencias
    public List<Gusto> getIdGustos_compartidos(String nombre_gusto){
       
        List<Gusto> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();            
            String hql = "From Gusto where nombre_gusto = :nombre_gusto";
            Query query = session.createQuery(hql);
            query.setParameter("nombre_gusto", nombre_gusto);
            result = (List<Gusto>)query.list();
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
    //Regresa una lista de Ids de los gustos con coincidencias
    public List<Gusto> getIdGustos_compartidos2(int id_gusto){
       
        List<Gusto> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();            
            String hql = "From Gusto where id_gusto = :id_gusto";
            Query query = session.createQuery(hql);
            query.setParameter("id_gusto", id_gusto);
            result = (List<Gusto>)query.list();
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
     
    
    //Regresa una lista de loss id's de las personas con coincidencias
      public List<UsuarioGusto> getPersonasId(int id_usuario){
       
        List<UsuarioGusto> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //Checar que amigos este bien si no cambiarlo por conocer.
            String hql = "From UsuarioGusto where id_usuario = :id_usuario";
            Query query = session.createQuery(hql);
            query.setParameter("id_usuario", id_usuario);
            result = (List<UsuarioGusto>)query.list();
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
      
      //Regresa una lista de loss id's de las personas con coincidencias
      public List<UsuarioGusto> getPersonasId2(int id_gusto){
       
        List<UsuarioGusto> result  = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //Checar que amigos este bien si no cambiarlo por conocer.
            String hql = "From UsuarioGusto where id_gusto = :id_gusto";
            Query query = session.createQuery(hql);
            query.setParameter("id_gusto", id_gusto);
            result = (List<UsuarioGusto>)query.list();
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
      
       public List<Usuario> getUsuarios(int id_usuario) {
        //Creamos una variable donde vamos a guardar el usuario solicitado
        List<Usuario> salida = null;
        //Se inicia la sesión
        Session session = sessionFactory.openSession();
        //...la transacción a realizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            /* Después del from nos referimos a la clase y nickname es el atributo de la clase */
            String hql = "FROM Usuario WHERE id_usuario = :id_usuario"; //inyectamos nickname en c
            Query query = session.createQuery(hql);
            query.setParameter("id_usuario", id_usuario);
            salida = (List<Usuario>)query.list();
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

}
