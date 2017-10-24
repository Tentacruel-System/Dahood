/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.mapeobd;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Hacemos el mapeo de un elemento de la tabla usuario a un objeto Usuario
 * @author Leonardo Gallo
 */
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;
           
    @Column(name = "nickname")
    private String nickname;
            
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido_p")
    private String apellido_p;

    @Column(name = "apellido_m")
    private String apellido_m;

    @Column(name = "contrasena")
    private String contrasena;
    
    @Column(name = "foto")
    private String foto;

    @Column(name = "correo")
    private String correo;
 
    //parece que es la relación establecida con otras tablas
    //@OneToMany(mappedBy = "Usuario") //esto para qué?
    //private Set<Marcador> marcadores; //es de la tabla o la base?

    /**
     * Permite obtener el id del usuario
     * @return  id_usuario
     */
    public int getIdUsuario() {
        return id_usuario;
    }

    /**
     * Permite cambiar el id del usuario
     * @param   id_usuario
     */
    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    /**
     * 
     * @return devuelve el nickname actual del usuario
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Cambia el nickname del usuario
     * @param nickname 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * Permite obtener el apellido paterno de usuario
     * @return apellido_p
     */
    public String getApellidoPaterno() {
        return apellido_p;
    }

    /**
     * Permite configurar el apellido paterno de usuario
     * @param apellido_p 
     */
    public void setApellidoPaterno(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    /**
     * 
     * @return devuelve el apellido materno del usuario
     */
    public String getApellidoMaterno() {
        return apellido_m;
    }

    /**
     * Cambia el apellido materno del usuario
     * @param apellido_m 
     */
    public void setApellidoMaterno(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    /**
     * Permite configurar la contraseña
     * @param contrasena 
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    /**
     * 
     * @return devuelve la ruta de la foto del perfil del usuario
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Permite cambiar la foto del perfil de usuario
     * @param foto 
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * 
     * @return devuelve el correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Cambia el correo del usuario
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

