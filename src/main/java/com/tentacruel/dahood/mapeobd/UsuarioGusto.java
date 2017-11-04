/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.mapeobd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@ Entity
@ Table(name = "usuario_gusto")
/**
 *
 * @author david
 */
public class UsuarioGusto {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gusto")
    private int id_gusto;
    @Column(name = "id_usuario")
    private int id_usuario;

    public int getId_gusto() {
        return id_gusto;
    }

    public void setId_gusto(int id_gusto) {
        this.id_gusto = id_gusto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
