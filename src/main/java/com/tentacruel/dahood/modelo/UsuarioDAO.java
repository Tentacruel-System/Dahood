/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.modelo;

import com.tentacruel.dahood.mapeobd.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Nos permite modificar datos en la tabla de Usuario
 * @author lgallo
 */
public class UsuarioDAO {
    
    /*Sesion para conectarnos a la base de datos*/
    private SessionFactory sessionFactory;

    /**
     * Inicialisamos la sesion a la base de datos.
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Guarda un usuario a la base de datos
     *
     * @param user el usuario a guardar.
     */
    public void guardar(Usuario user) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el marcador
            session.persist(user); //para guardar persist

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
     * Regresa la lista de todos los marcadores en la base de datos
     *
     * @return salida que es el usuario con el correo dado
     */
    public Usuario getUsuario(String nombre) {
        //Creamos una variable donde vamos a guardar el ususario solicitado
        Usuario salida = null;
        //Se inicia la sesión
        Session session = sessionFactory.openSession();
        //...la transacción a realizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            /* Después del from nos referimos a la clase y correo es el atributo de la clase */
            String hql = "FROM Usuario WHERE nombre =: c"; //inyectamos corre en c
            Query query = session.createQuery(hql);
            query.setParameter("c", nombre);
            salida = (Usuario)query.uniqueResult();
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
     * Regresa el marcador con el id dado
     *
     * @param id del usuario
     * @return el usuario con ese id
     */
    public Usuario getUsuarioId(int id) {
        //aqui va tu codigo
        //creamos una variable en donde guardar el marcador
        Usuario user = null;
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Usuario WHERE id_usuario = :idu";
            Query query = session.createQuery(hql);
            query.setParameter("idu", id);
            
            //Hacemos un cast de lo que obtenemos en el query a un obj Marcador
            user = (Usuario) query.uniqueResult();
            
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
        return user;
    }

    /**
     * Elimina el usuario de la base de datos
     *
     * @param user el usuario a eliminar
     */
    public void eliminar(Usuario user) {
        //aqui va tu codigo
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el marcador
            session.delete(user);
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
     * Actualiza el usuario en la base de datos
     *
     * @param user con los nuevos valores
     */
    public void actualizar(Usuario user) {
        //aqui va tu codigo
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el marcador
            session.update(user);

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
