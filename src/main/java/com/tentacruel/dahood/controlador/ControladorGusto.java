/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import com.tentacruel.dahood.mapeobd.Amigos;
import com.tentacruel.dahood.mapeobd.Gusto;
import com.tentacruel.dahood.mapeobd.UsuarioGusto;
import com.tentacruel.dahood.modelo.GustoDAO;
import java.util.List;
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
    
    @RequestMapping(value="/inicio", method = RequestMethod.GET)
    public ModelAndView amigos(ModelMap model){
        
        //Devuele una lista con los Id's de los gustos del usuario dado
        List<UsuarioGusto> gustosId = gusto_db.getGustoId(1);
        List<UsuarioGusto> resultados = null;
        UsuarioGusto usrG1;
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
                    for (UsuarioGusto id : ids) {
                        if(!resultados.contains(id)){ resultados.add(id);}
                    }
                    
                }
            
            }
        }
        
        model.addAttribute("coincidencias", resultados);
        System.out.println(resultados);
        
        return new ModelAndView("inicio",model);
        
       
    }
    
}
