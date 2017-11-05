/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.modelo;

import com.tentacruel.dahood.mapeobd.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.
UserDetailsService;
/**
 * Nos permite modificar datos en la tabla de usuario
 * @author Leonardo Gallo
 */
public class UsuarioDAO implements UserDetailsService {
    
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
            //guardamos el usuario
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
     * Regresa el usuario de la base de datos en forma de objeto
     *
     * @param nickname del usuario que se busca
     * @return salida que es el usuario con el nickname dado
     */
    public Usuario getUsuario(String nickname) {
        //Creamos una variable donde vamos a guardar el usuario solicitado
        Usuario salida = null;
        //Se inicia la sesión
        Session session = sessionFactory.openSession();
        //...la transacción a realizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            /* Después del from nos referimos a la clase y nickname es el atributo de la clase */
            String hql = "FROM Usuario WHERE nickname = :c"; //inyectamos nickname en c
            Query query = session.createQuery(hql);
            query.setParameter("c", nickname);
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
     * Elimina el usuario de la base de datos
     *
     * @param user el usuario a eliminar
     */
    public void eliminar(Usuario user) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el usuario
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
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el usuario
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
    
    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        Usuario usuario = this.getUsuario(username);
        if(usuario != null){
            List<GrantedAuthority> autorizacion =
                    new ArrayList<GrantedAuthority>();
            autorizacion.add(new SimpleGrantedAuthority("ROLE_USUARIO"));
            return new User(usuario.getNickname(),
                    usuario.getContrasena(),autorizacion);
        }else{
        throw new UsernameNotFoundException("Usuario" + username + 
                "no encontrado");
        }
    }
}
