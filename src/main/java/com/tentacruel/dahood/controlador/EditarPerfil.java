/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import com.tentacruel.dahood.mapeobd.Gusto;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.modelo.GustoDAO;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jesus
 */
@Controller
public class EditarPerfil {

    @Autowired
    UsuarioDAO usuario_db;
    @Autowired
    GustoDAO gusto_db;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="usuario_gusto",
        joinColumns = {@JoinColumn(name="id_usuario")},
        inverseJoinColumns = {@JoinColumn(name="id_gusto")})
    private Set<Gusto> newGustos = new HashSet<>();

    /**
     * Cambia a la vista de Editar Perfil
     *
     * @return la dirección de la página a visulizar
     */
    @RequestMapping(value = "/principal/editarPerfil", method = RequestMethod.GET)
    public ModelAndView vistaEditarPerfil(HttpServletRequest request, ModelMap model, Authentication authentication) {
        UserDetails usuario = (UserDetails) authentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);

        String nombre = user.getNombre();
        String apellidoPaterno = user.getApellidoPaterno();
        String apellidoMaterno = user.getApellidoMaterno();
        String nickname = user.getNickname();
        String correo = user.getCorreo();
        List<Gusto> gustos = gusto_db.getGustos();
        for (Gusto i : gustos) {
            System.out.println(i);
        }
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellidoPaterno", apellidoPaterno);
        model.addAttribute("apellidoMaterno", apellidoMaterno);
        model.addAttribute("nickname", nickname);
        model.addAttribute("correo", correo);
        model.addAttribute("gustos", gustos);

        return new ModelAndView("PantallaEditarPerfil", model);
    }

    /**
     * Permite modificar los datos de un usuario, primero se hace la petición y
     * se especifica el tipo, luego leemos los campos.
     *
     * @param request
     * @return nos regresa a la página principal
     */
    @RequestMapping(value = "/principal/editarPerfil", method = RequestMethod.POST)
    public String editarPerfil(HttpServletRequest request, Authentication authentication) {
        String nombre = request.getParameter("nombre");
        String apellido_p = request.getParameter("apellido_p");
        String apellido_m = request.getParameter("apellido_m");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        //String foto = request.getParameter("foto");

        List<Gusto> gustosGuardados = gusto_db.getGustos();
        Iterator<Gusto> it = gustosGuardados.iterator();

        //debe ser el nickname del usuario que esta en la sesion
        UserDetails usuario = (UserDetails) authentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        //Debemos verificar cuales son los campos que el ususario necesita actualizar
        if (!nombre.isEmpty()) {
            user.setNombre(nombre);
        }
        if (!apellido_p.isEmpty()) {
            user.setApellidoPaterno(apellido_p);
        }
        if (!apellido_m.isEmpty()) {
            user.setApellidoMaterno(apellido_m);
        }
        if (!correo.isEmpty()) {
            user.setCorreo(correo);
        }
        if (!contrasena.isEmpty()) {
            user.setContrasena(contrasena);
        }
        //if (!foto.isEmpty())
        //    user.setFoto(foto);

        while (it.hasNext()) {
            Gusto gustoExistente = it.next();
            String nombreGusto = gustoExistente.getNombre_gusto();
            String gustoParametro = request.getParameter(nombreGusto);
            System.out.print("ESte es el parametro: " + gustoParametro + "\n");
            if (gustoParametro != null) {
                user.agregarGusto(gustoExistente);
            }
        }

        //persistencia en la base de datos
        //se actualiza directo en la base de datos
        usuario_db.actualizar(user);
        return "redirect:/principal/verPerfil";
    }
}
