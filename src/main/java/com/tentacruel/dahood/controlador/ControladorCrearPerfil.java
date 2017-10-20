/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lgallo
 */
@Controller //Notación para spring
public class ControladorCrearPerfil {
    /*Injectamos el modelo del usuario */
    @Autowired
    UsuarioDAO usuario_db;
    
    /**
     * Almacena los datos básicos de un usuario en la base de datos
     * @param request los atributos del usuario
     * @return la dirección de la página a visulizar
     */
    @RequestMapping(value="/crear_perfil", method = RequestMethod.POST)
    public String crearPerfil(HttpServletRequest request){
        String nombre = request.getParameter("nombre");//en el jsp debe llamarse igual
//        String 
//        Double longitud = Double.parseDouble(request.getParameter("longitud"));//*
//        String nombre = request.getParameter("nombre");//*
//        String descripcion = request.getParameter("descripcion");//*
//        Marcador ma = marcador_db.getMarcador(latitud, longitud);
//        if(ma == null){
//            Marcador m  = new Marcador();
//            m.setLatitud(latitud);
//            m.setLongitud(longitud);
//            m.setNombre(nombre);
//            m.setDescripcion(descripcion);
//            marcador_db.guardar(m);    
//        }
        return "redirect:/";
    }
}
