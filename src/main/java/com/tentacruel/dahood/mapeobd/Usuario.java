/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.mapeobd;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Hacemos el mapeo de un elemento de la tabla Usuario a un objeto Usuario
 * @author lgallo
 */
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;
    
    @Column(name = "nickname")
    private String nickname;
            
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "contrasena")
    private String contrasena;
    
    @Column(name = "apellido_p")
    private String apellido_p;

    @Column(name = "apellido_m")
    private String apellido_m;

    @Column(name = "foto")
    private String foto;

    //parece que es la relación establecida con otras tablas
    //@OneToMany(mappedBy = "Usuario") //esto para qué?
    //private Set<Marcador> marcadores; //es de la tabla o la base?

    /**
     * Permite obtener el id del usuario
     * @return  id_usuario
     */
    public int getIdusuario() {
        return id_usuario;
    }

    /**
     * Permite cambiar el id del usuario
     * @param   id_usuario
     */
    public void setIdusuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Permite obtener el nombre del usuario
     * @return  nickname
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Permite cambiar el nombre del usuario
     * @param nickname 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la contraseña actual del usuario
     * este método no da seguridad!!!
     * @return contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Permite configurar la contraseña
     * @param contrasena 
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    /**
     * Permite obtener el apellido paterno de usuario
     * @return apellido_p
     */
    public String getApellido_p() {
        return apellido_p;
    }

    /**
     * Permite configurar el apellido paterno de usuario
     * @param apellido_p 
     */
    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    /**
     * 
     * @return 
     */
    public String getApellido_m() {
        return apellido_m;
    }

    /**
     * 
     * @param apellido_m 
     */
    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    /**
     * 
     * @return 
     */
    public String getFoto() {
        return foto;
    }

    /**
     * 
     * @param foto 
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }    
}

