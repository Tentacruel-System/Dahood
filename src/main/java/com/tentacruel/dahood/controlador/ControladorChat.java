/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.tentacruel.dahood.controlador;

import com.tentacruel.dahood.mapeo.Chat;
import com.tentacruel.dahood.modelo.ChatDAO;
import com.tentacruel.dahood.mapeo.Amigos;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;



/**
 *
 * @author orlando
 */
@Controller
public class ControladorChat {
    
    @Autowired
    ChatDAO chat_db;

    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView amigos(ModelMap model){
        
        List<Amigos> friends = chat_db.getAmigos(1);
        
        model.addAttribute("amigos", friends);
        System.out.println(friends);
        
        return new ModelAndView("Chatear",model);
        
       
    }
}
