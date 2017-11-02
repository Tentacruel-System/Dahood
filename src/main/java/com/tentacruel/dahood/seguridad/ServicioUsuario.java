/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.seguridad;
import java.util.List;
import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.
SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.
UserDetailsService;
import org.springframework.security.core.userdetails.
UsernameNotFoundException;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import com.tentacruel.dahood.mapeobd.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jesus
 */
public class ServicioUsuario implements UserDetailsService{
    private final UsuarioDAO usuarioDB;
    
    @Autowired
    public ServicioUsuario(UsuarioDAO usuarioDB){
        this.usuarioDB = usuarioDB;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        Usuario usuario = usuarioDB.getUsuario(username);
        if(usuario != null){
            List<GrantedAuthority> autorizacion =
                    new ArrayList<GrantedAuthority>();
            autorizacion.add(new SimpleGrantedAuthority("ROLE_USUARIO"));
            return new User(usuario.getNickname(),
                    usuario.getContrasena(),autorizacion);
        }else{
        throw new UsernameNotFoundException("Usuario" + username + 
                "no encontrado");
        }
    }
    
}
