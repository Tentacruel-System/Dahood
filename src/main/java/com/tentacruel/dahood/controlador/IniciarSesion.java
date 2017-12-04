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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

/**
 *
 * @author jesus
 */
@Controller
public class IniciarSesion {
    
//    @RequestMapping(value ="/", method = RequestMethod.GET)
//    public String mostrarPantallaInicio(){
//        return "PantallaInicio";
//    }
    
    @RequestMapping(value="/iniciarsesion", method = RequestMethod.GET)
    public String mostrarPantallaIniciarSesion(){
        return "PantallaIniciarSesion";
    }
    
    @RequestMapping(value="/principal",method = RequestMethod.GET)
    public String mostrarPantallaPrincipal(){
        return "PantallaPrincipal";
    }
    
    @RequestMapping(value="/principal/salir", method = RequestMethod.GET)
    public String salir (HttpServletRequest request, HttpServletResponse response, RedirectAttributes model, Model model1){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            System.out.println(model1.containsAttribute("perfilEliminado"));
            if(model1.containsAttribute("perfilEliminado")){
                model.addFlashAttribute("perfilEliminado1", "Tu perfil ha sido exitosamente eliminado");
            }
            model.addFlashAttribute("exito", "Ha salido de su perfil exitosamente");
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/?salir";
    }
}
