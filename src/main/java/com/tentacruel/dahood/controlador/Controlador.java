/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author maw
 */
@Controller
public class Controlador {
    
   @RequestMapping(value="/", method = RequestMethod.GET)
    public String dahood(ModelMap model){
          
        
        return"crear_perfil";
    
    }
    
}
