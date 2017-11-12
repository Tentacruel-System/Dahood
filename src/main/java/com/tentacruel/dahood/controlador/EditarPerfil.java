/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

/**
 *
 * @author jesus
 */
@Controller
public class EditarPerfil {
    @Autowired
    UsuarioDAO usuario_db;
    /**
     * Cambia a la vista de Editar Perfil
     * @return la dirección de la página a visulizar
     */
    @RequestMapping(value="/principal/editarPerfil", method = RequestMethod.GET)
    public String vistaEditarPerfil(){
        return "PantallaEditarPerfil";
    }
    
    /**
     * Permite modificar los datos de un usuario, primero 
     * se hace la petición y se especifica el tipo, luego
     * leemos los campos.
     * @param request
     * @return nos regresa a la página principal
     */
    @RequestMapping(value= "/principal/editarPerfil", method = RequestMethod.POST)
    public String editarPerfil(HttpServletRequest request, Authentication authentication){
        String nombre = request.getParameter("nombre");
        String apellido_p = request.getParameter("apellido_p");
        String apellido_m = request.getParameter("apellido_m");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String foto = request.getParameter("foto");
        
        //debe ser el nickname del usuario que esta en la sesion
        UserDetails usuario = (UserDetails) authentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        //Debemos verificar cuales son los campos que el ususario necesita actualizar
        if (!nombre.isEmpty())
            user.setNombre(nombre);
        if (!apellido_p.isEmpty())
            user.setApellidoPaterno(apellido_p);
        if (!apellido_m.isEmpty())
            user.setApellidoMaterno(apellido_m);
        if (!correo.isEmpty())
            user.setCorreo(correo);
        if (!contrasena.isEmpty())
            user.setContrasena(contrasena);
        if (!foto.isEmpty())
            user.setFoto(foto);
        //persistencia en la base de datos
        //se actualiza directo en la base de datos
        usuario_db.actualizar(user);
        return "redirect:/principal";
    }
}
