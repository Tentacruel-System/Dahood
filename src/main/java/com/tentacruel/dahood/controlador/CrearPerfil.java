
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.mapeobd.Gusto;
import java.util.List;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.tentacruel.dahood.modelo.GustoDAO;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/**
 *
 * @author Leonardo Gallo
 */
@Controller //Notación para spring
public class CrearPerfil {
    /*Inyectamos el modelo del usuario */
    @Autowired
    UsuarioDAO usuario_db;
    @Autowired
    GustoDAO gusto_db;
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
        List<Gusto> gustosGuardados = gusto_db.getGustos();
        Iterator<Gusto> it = gustosGuardados.iterator();
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
            //newuser.setFoto("");
            while(it.hasNext()){
                Gusto gustoExistente = it.next();
                String nombreGusto = gustoExistente.getNombre_gusto();
                String gustoParametro = request.getParameter(nombreGusto);
                System.out.print("ESte es el parametro: "+ gustoParametro + "\n");
                if(gustoParametro != null){
                    newuser.agregarGusto(gustoExistente);
                }   
            }
            usuario_db.guardar(newuser);
        }
        return "redirect:/";
    }
    
    /**
     * Cambia a la vista de Crear Perfil
     * @return la dirección de la página a visulizar
     */
    @RequestMapping(value="/crearPerfil", method = RequestMethod.GET)
    public ModelAndView vistaPerfil(ModelMap model){
        List<Gusto> gustos = gusto_db.getGustos(); 
        model.addAttribute("gustos",gustos);
        return new ModelAndView("PantallaCrearPerfil", model);
    }
  
}