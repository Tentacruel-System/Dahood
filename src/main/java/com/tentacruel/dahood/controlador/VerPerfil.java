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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jesus
 */
@Controller
public class VerPerfil {
    @Autowired
    UsuarioDAO usuario_db;
    @RequestMapping(value= "/principal/verPerfil", method = RequestMethod.GET)
    public ModelAndView verPerfil(HttpServletRequest request, ModelMap model, Authentication authentication){
        UserDetails usuario = (UserDetails) authentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        
        String nombre = user.getNombre() + " " + user.getApellidoPaterno() + " " + user.getApellidoMaterno();
        String nickname = user.getNickname();
        String correo= user.getCorreo();
        model.addAttribute("nombre", nombre);
        model.addAttribute("nickname", nickname);
        model.addAttribute("correo", correo);
        
        return new ModelAndView("PantallaVerPerfil",model);
    }
}