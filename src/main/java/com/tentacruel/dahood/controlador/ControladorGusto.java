/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import com.tentacruel.dahood.mapeobd.Amigos;
import com.tentacruel.dahood.mapeobd.Gusto;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.mapeobd.UsuarioGusto;
import com.tentacruel.dahood.modelo.GustoDAO;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author david
 */
@Controller 
public class ControladorGusto {
    @Autowired
    GustoDAO gusto_db;
    UsuarioDAO usuario_db;
    
    /*@RequestMapping(value="/buscar", method = RequestMethod.GET)
    public ModelAndView coincidencias(ModelMap model){
        
        //Devuele una lista con los Id's de los gustos del usuario dado
        List<UsuarioGusto> gustosId = gusto_db.getGustoId(1);
        List<UsuarioGusto> resultados = gusto_db.getGustoId(1);
        UsuarioGusto usrG1, usrG2;
        Gusto gus1, gus2;
        for(int i = 0; i< gustosId.size(); i++){
            usrG1 = gustosId.get(i);
            //Regresan una lista con el nombre de los gustos dado el Id del gusto
            List<Gusto> nom_gusto = gusto_db.getGustoNombre(usrG1.getId_gusto());
            for(int j = 0; j< nom_gusto.size(); j++){
                gus1 = nom_gusto.get(j);
                //Regresa una lista de Ids de los gustos con coincidencias
                List<Gusto> gusto_compartido = gusto_db.getIdGustos_compartidos(gus1.getNombre_gusto());
                for(int k = 0; k< gusto_compartido.size(); k++){
                    gus2 = gusto_compartido.get(k);
                    //Regresa una lista de loss id's de las personas con coincidencias
                    List<UsuarioGusto> ids = gusto_db.getPersonasId(gus2.getId_gusto());
                    for(int l = 0; l< ids.size(); l++) {
                        //if(!resultados.contains(id)){ resultados.add(id);}
                        usrG2 = ids.get(l);
                        if(!resultados.contains(usrG2)){ resultados.add(usrG2);}
                        //resultados.add(usrG2);
                    }
                    
                }
            
            }
        }
        
        model.addAttribute("coincidencias", resultados);
        System.out.println(resultados);
        System.out.println("hola");
        
        return new ModelAndView("buscar",model);              
    }*/
    
    @RequestMapping(value="/buscar", method = RequestMethod.GET)
    public ModelAndView coincidencias2(ModelMap model){
        
        //Devuele una lista con los Id's de los gustos del usuario dado
        List<UsuarioGusto> gustosId = gusto_db.getGustoId(1); 
        List<Usuario> resultados = gusto_db.getUsuarios(1);
        List<UsuarioGusto> gusto_comp;
        Usuario usuario;
        
        //List<UsuarioGusto> resultados = gusto_db.getGustoId(1);;
        UsuarioGusto usrG1, usrG2, usrG3;
        List<Usuario> usr;
        
  //      Gusto gus1, gus2;
        for(int i = 0; i< gustosId.size(); i++){
            usrG1 = gustosId.get(i);           
            gusto_comp = gusto_db.getPersonasId2(usrG1.getId_gusto());          
            for (int j = 0; j < gusto_comp.size(); j++) {
                usrG3 = gusto_comp.get(j);
                usr = gusto_db.getUsuarios(usrG3.getId_usuario());
                for(int k = 0; k < usr.size(); k++){
                    usuario = usr.get(k);
                    if((usuario != null) && (!resultados.contains(usuario))) {resultados.add(usuario);}                    
                
                }                
                
                
                
            }
        }
        model.addAttribute("coincidencias2", resultados);
        System.out.println(resultados);
        System.out.println("hola");
        
        return new ModelAndView("buscar",model);
        
       
    }
    /*
    @RequestMapping(value="/buscar_1", method = RequestMethod.GET)
    public ModelAndView coincidencias3(ModelMap model){
        
        //Devuele una lista con los Id's de los gustos del usuario dado
        List<UsuarioGusto> gustosId = gusto_db.getGustoId(1);  
        
        Usuario1 usr = usuario_db.getUsuario("dav");       
        Set<Gusto1> cjt_gusto = usr.getGustos();
        
        List<UsuarioGusto> resultados = gusto_db.getGustoId(1);;
        UsuarioGusto usrG1, usrG2;
        Gusto gus1, gus2;
        
        model.addAttribute("coincidencias3", cjt_gusto);
        System.out.println(cjt_gusto);
        System.out.println("holaaaaaaaaaa");
        
        return new ModelAndView("buscar_1",model);
        
       
    }*/
    
}
