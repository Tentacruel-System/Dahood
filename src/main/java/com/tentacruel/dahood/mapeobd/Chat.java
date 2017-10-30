/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.mapeobd;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@ Entity
@ Table(name = "usuario")
/**
 *
 * @author orlando
 */
public class Chat {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chat")
    private int id_chat;
    @Column(name = "id_usuario1")
    private int id_usuario1;
    @Column(name = "id_usuario2")
    private int id_usuario2;
    @Column(name = "fecha")
    private String  fecha;
    
    private String texto;
   

    public Chat( int usuario1, String texto){
        
        this.texto = texto;
        this.id_usuario1 = usuario1;
        
        
    }
    
    public int getId_chat() {
        return id_chat;
    }

    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
    }

    public int getId_usuario1() {
        return id_usuario1;
    }

    public void setId_usuario1(int id_usuario1) {
        this.id_usuario1 = id_usuario1;
    }

    public int getId_usuario2() {
        return id_usuario2;
    }

    public void setId_usuario2(int id_usuario2) {
        this.id_usuario2 = id_usuario2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    
    
}
