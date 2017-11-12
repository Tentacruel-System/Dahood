/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import com.tentacruel.dahood.mapeobd.Amigos;
import com.tentacruel.dahood.mapeobd.Gusto;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.modelo.GustoDAO;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import java.util.Set;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.HashSet;
import java.util.Collections;   
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author david
 */
@Controller 
public class Buscar {
    @Autowired
    GustoDAO gusto_db;
    @Autowired
    UsuarioDAO usuario_db;
    
    
    @RequestMapping(value="/principal/buscar", method = RequestMethod.GET)
    public ModelAndView coincidencias(ModelMap model, Authentication authentication){
        UserDetails usuario = (UserDetails) authentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        //Obtenemos el conjunto de gustos del usuario
        Set<Gusto> gustos = user.getGustos();
        //Creamos un iterador del conjunto de gustos
        Iterator<Gusto> primerIteradorGusto = gustos.iterator();
        //Obtenemos el primer gusto de dicho conjunto
        Gusto primerGusto = primerIteradorGusto.next();
        //Copiamos el conjunto de usuarios del primer gusto del usuario autenticado
        //Usamos este conjunto como base para la unión de todos los conjuntos de usuarios
        //de los gustos que tiene el usuario autenticado.
        //Esto se hace porque al unir dos conjuntos, el conjunto que llamó a la función
        //de unión se modifica para convertirse en la unión.
        Set<Usuario> unionUsuarios = new HashSet<>(primerGusto.getUsuarios());
        //Unimos los conjuntos de usuarios de los demás gustos
        while(primerIteradorGusto.hasNext()){
            Gusto gustoDeUsuario = primerIteradorGusto.next();
            unionUsuarios.addAll(gustoDeUsuario.getUsuarios());
        }
        //Creamos un iterador para el conjunto de todos los usuarios con lo que 
        //el usuario autenticado comparte al menos un gusto.
        Iterator<Usuario> iteradorUsuario = unionUsuarios.iterator();
        Iterator<Gusto> segundoIteradorGusto = gustos.iterator();
        List<Pair> usuarioCompatibilidad = new LinkedList<>();
        double numeroGustos = gustos.size();
        while(iteradorUsuario.hasNext()){
            double compatibilidad;
            Usuario usuarioActual = iteradorUsuario.next();
            int numeroDeCoincidencias = 0;
            if(!usuarioActual.equals(user)){
                while(segundoIteradorGusto.hasNext()){
                    Set<Usuario> usuariosDeGusto = segundoIteradorGusto.next().getUsuarios();
                    if(usuariosDeGusto.contains(usuarioActual)){
                        numeroDeCoincidencias++;
                    }
                }
                compatibilidad = numeroDeCoincidencias / numeroGustos;
                usuarioCompatibilidad.add(new Pair(usuarioActual,compatibilidad)); 
            }
        }
        Collections.sort(usuarioCompatibilidad);
        model.addAttribute("usuarios",usuarioCompatibilidad);
        return new ModelAndView("PantallaBuscar", model);
    }
    
    private class Pair implements Comparable<Pair>{
        private final Usuario u;
        private final double compatibilidad;
        
        public Pair(Usuario u, double compatibilidad){
            this.u = u;
            this.compatibilidad = compatibilidad;
        }
        
        public Usuario getUsuario(){
            return this.u;
        }
        
        public double getCompatibilidad(){
            return this.compatibilidad;
        }
        @Override
        public int compareTo(Pair p){
            return -1 * Double.compare(p.compatibilidad,this.compatibilidad);
            
        }
    }
}