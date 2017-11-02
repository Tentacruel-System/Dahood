/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;
import java.util.List;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import com.tentacruel.dahood.mapeobd.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author jesus
 */
@Controller
public class IniciarSesion {
    
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String mostrarPantallaInicio(){
        return "PantallaInicio";
    }
    
    @RequestMapping(value="/iniciarsesion", method = RequestMethod.POST)
    public String mostrarPantallaIniciarSesion(){
        return "PantallaIniciarSesion";
    }
    
    @RequestMapping(value="/crearperfil", method = RequestMethod.POST)
    public String mostrarPantallaCrearPerfil(){
        return "PantallaCrearPerfil";
    }
}
