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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;  

/**
 *
 * @author jesus
 */
@Controller
public class EliminarPerfil {
    @Autowired
    UsuarioDAO usuario_db;
    
    @RequestMapping(value="/principal/confirmarEliminarPerfil", method = RequestMethod.GET)
    public String confirmarEliminarPerfil(){
        return "PantallaConfirmarEliminarPerfil";
    }
    @RequestMapping(value="/principal/eliminarPerfil", method=RequestMethod.POST)
    public String eliminarPerfil(HttpServletRequest request, 
            Authentication authentication, RedirectAttributes model){
        String contrasenaConfirmacion = request.getParameter("contrasena");
        UserDetails usuario = (UserDetails) authentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        String contrasenaUsuarioLoggeado = user.getContrasena();
        System.out.println(contrasenaConfirmacion + " " + contrasenaUsuarioLoggeado + " " + usuario.getUsername());
        if(contrasenaConfirmacion.equals(contrasenaUsuarioLoggeado)){
            usuario_db.eliminar(user);
            model.addFlashAttribute("perfilEliminado", "Tu perfil ha sido exitosamente eliminado");
            return "redirect:/principal/salir";
        }
        else{
            model.addAttribute("errorConfirmacionContrasena",
                    "Contraseña incorrecta. Intente de nuevo");
            return "PantallaConfirmarEliminarPerfil";
        }
        
    }   
}
