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
import java.util.ArrayList;
import java.util.Date;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @author orlando
 */
@Controller
public class Chatear {
    
    @Autowired
    ChatDAO chat_db;
    
    @Autowired
    UsuarioDAO usuario_db;

    
    /*@RequestMapping(value="/principal/chat", method = RequestMethod.GET)
    public ModelAndView amigos(ModelMap model,Authentication aunthentication){
        
        UserDetails usuario = (UserDetails) aunthentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        
        List<Amigos> friends = chat_db.getAmigos(user.getIdUsuario());
       
        
        model.addAttribute("amigos", friends);
        return new ModelAndView("PantallaChat",model);
        
       
    }*/

    @MessageMapping("/principal/chat")
    @SendTo("/topic/messages")
    public Chat send( String texto, Authentication aunthentication, @RequestParam("param") String usr) throws Exception {
        String time = new SimpleDateFormat("d MMM yyyy HH:mm").format(new Date());
       
        UserDetails usuario = (UserDetails) aunthentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        return new Chat(user.getNickname(),texto, time);
    }
   
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String dahood(ModelMap model){
    
    
        return"inicio";
    
    }

    
    @RequestMapping(value = "/principal/chat", method = RequestMethod.GET)
    public ModelAndView chatear(HttpServletRequest request, ModelMap model, Authentication aunthentication){
        UserDetails usuario = (UserDetails) aunthentication.getPrincipal();
        String usuarioLoggeado = usuario.getUsername();
        Usuario user = usuario_db.getUsuario(usuarioLoggeado);
        
        
        String nickname = user.getNickname();
        String nombre = user.getNombre() + " " + user.getApellidoPaterno();
        String correo = user.getCorreo();
        
        
        List<Amigos> friends = chat_db.getAmigos(user.getIdUsuario( ));
        List<String> amaigos = new ArrayList<String>();
        for (Amigos row: friends) {
            System.out.println(" ------------------- ");
            System.out.println("id: " + (usuario_db.getUsuarioByID(row.getAmigo())).getNickname());
            System.out.println("Usuario: " + row.getUsuario());
            System.out.println("Amigo: " + row.getAmigo());
            amaigos.add(usuario_db.getUsuarioByID(row.getAmigo()).getNickname());
            
            
        }
        System.out.println(amaigos);
        model.addAttribute("lel", amaigos);
        model.addAttribute("amigos", friends); 
        model.addAttribute("nombre", nombre);
        model.addAttribute("nickname", nickname);
        model.addAttribute("correo", correo);
        
        
        
        
        return new ModelAndView("PantallaChat", model);
        
    }
    
}



