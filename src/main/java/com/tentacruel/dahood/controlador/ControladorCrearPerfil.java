/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import javax.servlet.http.HttpServletRequest;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Leonardo Gallo
 */
@Controller //Notación para spring
public class ControladorCrearPerfil {
    /*Inyectamos el modelo del usuario */
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
        String apellido_p = request.getParameter("apellido_p");
        String apellido_m = request.getParameter("apellido_m");
        String nickname = request.getParameter("nickname");
        String correo = request.getParameter("corre");
        String contrasena = request.getParameter("contrasena");
        String confcontrasena = request.getParameter("confcontrasena");
        /* Verificamos que no exista otro usuario con el mismo correo o nickname */
        Usuario user = usuario_db.getUsuario(nickname);
        if(user == null && contrasena == confcontrasena){
            Usuario newuser = new Usuario();
            newuser.setNombre(nombre);
            newuser.setApellidoPaterno(apellido_p);
            newuser.setApellidoMaterno(apellido_m);
            newuser.setNickname(nickname);
            newuser.setCorreo(correo);
            newuser.setContrasena(contrasena);
        }
        return "redirect:/";
    }
}
