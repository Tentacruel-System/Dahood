/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import javax.servlet.http.HttpServletRequest;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Leonardo Gallo
 */
@Controller //Notación para spring
public class ControladorPerfil {
    /*Inyectamos el modelo del usuario */
    @Autowired
    UsuarioDAO usuario_db;
    
    /**
     * Almacena los datos básicos de un usuario en la base de datos
     * @param request los atributos del usuario
     * @return la dirección de la página a visulizar
     */
    @RequestMapping(value="/crearPerfil", method = RequestMethod.POST)
    public String crearPerfil(HttpServletRequest request){
        String nombre = request.getParameter("nombre");//en el jsp debe llamarse igual
        String apellido_p = request.getParameter("apellido_p");
        String apellido_m = request.getParameter("apellido_m");
        String nickname = request.getParameter("nickname");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String confcontrasena = request.getParameter("confcontrasena");
        /* Verificamos que no exista otro usuario con el mismo correo o nickname */
        Usuario user = usuario_db.getUsuario(nickname);
        if(user == null){
            Usuario newuser = new Usuario();
            newuser.setNombre(nombre);
            newuser.setApellidoPaterno(apellido_p);
            newuser.setApellidoMaterno(apellido_m);
            newuser.setNickname(nickname);
            newuser.setCorreo(correo);
            newuser.setContrasena(contrasena);
            newuser.setFoto("");
            usuario_db.guardar(newuser);
        }
        return "redirect:/";
    }
    
    /**
     * Cambia a la vista de Crear Perfil
     * @return la dirección de la página a visulizar
     */
    @RequestMapping(value="/vistaCrearPerfil", method = RequestMethod.GET)
    public String vistaPerfil(){
        return "crearPerfil";
    }
    
    /**
     * Cambia a la vista de Editar Perfil
     * @return la dirección de la página a visulizar
     */
    @RequestMapping(value="/vistaEditarPerfil", method = RequestMethod.GET)
    public String vistaEditarPerfil(){
        return "editarPerfil";
    }
    
    /**
     * Permite modificar los datos de un usuario, primero 
     * se hace la petición y se especifica el tipo, luego
     * leemos los campos.
     * @param request
     * @return nos regresa a la página principal
     */
    @RequestMapping(value= "/editarPerfil", method = RequestMethod.POST)
    public String editarPerfil(HttpServletRequest request){
        String nombre = request.getParameter("nombre");
        String apellido_p = request.getParameter("apellido_p");
        String apellido_m = request.getParameter("apellido_m");
        String nickname = request.getParameter("nickname");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String foto = request.getParameter("foto");
        
        //debe ser el nickname del usuario que esta en la sesion
        Usuario user = usuario_db.getUsuario(nickname);
        //Debemos verificar cuales son los campos que el ususario necesita actualizar
        if (!nombre.isEmpty())
            user.setNombre(nombre);
        if (!apellido_p.isEmpty())
            user.setApellidoPaterno(apellido_p);
        if (!apellido_m.isEmpty())
            user.setApellidoMaterno(apellido_m);
        if (!nickname.isEmpty())
            user.setNickname(nickname);
        if (!correo.isEmpty())
            user.setCorreo(correo);
        if (!contrasena.isEmpty())
            user.setContrasena(contrasena);
        if (!foto.isEmpty())
            user.setFoto(foto);
        //persistencia en la base de datos
        //se actualiza directo en la base de datos
        usuario_db.actualizar(user);
        return "redirect:/";
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    @RequestMapping(value= "/verPerfil", method = RequestMethod.GET)
    public String verPerfil(Usuario user){
        return "";
    }
}