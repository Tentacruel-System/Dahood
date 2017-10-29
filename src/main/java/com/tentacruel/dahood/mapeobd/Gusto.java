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

/**
 *
 * @author david
 */
@Entity
@Table(name = "gusto")
public class Gusto {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gusto")
    private int id_gusto;
           
    @Column(name = "nombre_gusto")
    private String nombre_gusto;

    public int getId_gusto() {
        return id_gusto;
    }

    public void setId_gusto(int id_gusto) {
        this.id_gusto = id_gusto;
    }

    public String getNombre_gusto() {
        return nombre_gusto;
    }

    public void setNombre_gusto(String nombre_gusto) {
        this.nombre_gusto = nombre_gusto;
    }
    
    
}
