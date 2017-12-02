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
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;
import javax.persistence.FetchType;
/**
 * Hacemos el mapeo de un elemento de la tabla usuario a un objeto Usuario
 * @author Leonardo Gallo
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
   
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
           
    @Column(name = "nickname")
    private String nickname;
            
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido_p")
    private String apellidoPaterno;

    @Column(name = "apellido_m")
    private String apellidoMaterno;

    @Column(name = "contrasena")
    private String contrasena;
    
    //@Column(name = "foto")
    //private String foto;

    @Column(name = "correo")
    private String correo;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="usuario_gusto",
        joinColumns = {@JoinColumn(name="id_usuario")},
        inverseJoinColumns = {@JoinColumn(name="id_gusto")})
    private Set<Gusto> gustos = new HashSet<>();
                
    //parece que es la relación establecida con otras tablas
    //@OneToMany(mappedBy = "Usuario") //esto para qué?
    //private Set<Marcador> marcadores; //es de la tabla o la base?

    /**
     * Permite obtener el id del usuario
     * @return  idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Permite cambiar el id del usuario
     * @param   id_usuario
     */
    public void setIdUsuario(int id_usuario) {
        this.idUsuario = id_usuario;
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
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Permite obtener el apellido paterno de usuario
     * @return apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Permite configurar el apellido paterno de usuario
     * @param apellido_p 
     */
    public void setApellidoPaterno(String apellido_p) {
        this.apellidoPaterno = apellido_p;
    }

    /**
     * 
     * @return devuelve el apellido materno del usuario
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Cambia el apellido materno del usuario
     * @param apellido_m 
     */
    public void setApellidoMaterno(String apellido_m) {
        this.apellidoMaterno = apellido_m;
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
     *
    public String getFoto() {
        return foto;
    }

    /**
     * Permite cambiar la foto del perfil de usuario
     * @param foto 
     *
    public void setFoto(String foto) {
        this.foto = foto;
    }
**/
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

    /**
     * Da la contrasena del usuario
     * @return Contrasena del usuario 
     */
    public String getContrasena(){
        return this.contrasena;
    }
    
    /**
     * Regresa el conjunto de gustos de este usuario
     * @return Conjunto de gustos
     */
    public Set<Gusto> getGustos(){
        return this.gustos;
    }
    
    /**
     * @param gustos Conjunto de gustos 
     */
    public void setGustos(Set<Gusto> gustos){
        this.gustos = gustos;
    }
    
    /**
     * Agrega un gusto a la lista de gustos del usuario.
     * También agregar este objeto a la lista de usuario
     * del gusto que se va a agregar.
     * @param g El gusto a agregar
     */
    public void agregarGusto(Gusto g){
        this.gustos.add(g);
        g.getUsuarios().add(this);
    }
    
    /**
     * Elimina un gusto de la lista de gusto del usuario.
     * También elimina este usuario de la lista de usuarios del
     * gusto que se va a eliminar.
     * @param g El gusto a eliminar 
     */
    public void eliminarGusto(Gusto g){
        this.gustos.remove(g);
        g.getUsuarios().remove(this);
    }
 }


