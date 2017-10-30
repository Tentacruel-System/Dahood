/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.tentacruel.dahood.controlador;

import com.tentacruel.dahood.mapeobd.Chat;
import com.tentacruel.dahood.modelo.ChatDAO;
import com.tentacruel.dahood.mapeobd.Amigos;
import com.tentacruel.dahood.modelo.Mensaje;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
//import com.baeldung.model.Message;
//import com.baeldung.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;



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
    
@MessageMapping("/chat")
@SendTo("/topic/messages")
public Chat send(Mensaje  mensaje) throws Exception {
    //String time = new SimpleDateFormat("HH:mm").format(new Date());
    return new Chat(mensaje.getUsuario(), mensaje.getTexto());
}
}

