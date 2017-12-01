/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.tentacruel.dahood.mapeobd;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@ Entity
@ Table(name = "conocer")
/**
 *
 * @author orlando
 */
public class Amigos implements Serializable{
    @Id      
    @Column(name = "usuario")
    private int usuario;
   
    @Column(name = "amigo")
    private int amigo;
    
    
    
    public int getUsuario() {
        return usuario;
    }
    
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    public int getAmigo() {
        return amigo;
    }
    
    public void setAmigo(int amigo) {
        this.amigo = amigo;
    }
    
    
}
