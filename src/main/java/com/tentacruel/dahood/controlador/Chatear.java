/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.tentacruel.dahood.controlador;

import com.tentacruel.dahood.mapeobd.Chat;
import com.tentacruel.dahood.modelo.ChatDAO;
import com.tentacruel.dahood.mapeobd.Amigos;
import com.tentacruel.dahood.mapeobd.Usuario;
import com.tentacruel.dahood.modelo.Mensaje;
import com.tentacruel.dahood.modelo.UsuarioDAO;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;



/**
 *
 * @author orlando
 */
@Controller
public class Chatear {
    
    @Autowired
    ChatDAO chat_db;

    
    @RequestMapping(value="/inicio", method = RequestMethod.GET)
    public ModelAndView amigos(ModelMap model){
        
        List<Amigos> friends = chat_db.getAmigos(1);
        
        model.addAttribute("amigos", friends);
        System.out.println(friends);
        
        return new ModelAndView("Chatear",model);
        
       
    }

    @MessageMapping("/principal/chat")
    @SendTo("/topic/messages")
    public Chat send(String  usuario, String texto) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        System.out.println(usuario);
        return new Chat(1, texto, time);
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String dahood(ModelMap model){
          
        
        return"inicio";
    
    }
    
    /** @RequestMapping(value="/principal/chat", method = RequestMethod.GET)
    public String dahood1(ModelMap model){
          
        
        return"chat-test";
    
    }*/
    @Autowired
    UsuarioDAO usuario_db;
    
    @RequestMapping(value = "/principal/chat", method = RequestMethod.GET)
    public ModelAndView chatear(HttpServletRequest request, ModelMap model, Authentication aunthentication){
        UserDetails usuario = (UserDetails) aunthentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        
        
        String nickname = user.getNickname();
        String nombre = user.getNombre() + " " + user.getApellidoPaterno();
        String correo = user.getCorreo();
        
        model.addAttribute("nombre", nombre);
        model.addAttribute("nickname", nickname);
        model.addAttribute("correo", correo);
        
        return new ModelAndView("chat-test", model);
        
    }
    
}



