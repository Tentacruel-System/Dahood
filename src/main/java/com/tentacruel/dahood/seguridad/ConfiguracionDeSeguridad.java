/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tentacruel.dahood.seguridad;
import com.tentacruel.dahood.modelo.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.
authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.
configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.
        configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 *
 * @author jesus
 */
@Configuration
@EnableWebSecurity
public class ConfiguracionDeSeguridad extends WebSecurityConfigurerAdapter{
    @Autowired
    private UsuarioDAO usuarioDB;
    
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
    throws Exception {
        auth.inMemoryAuthentication().withUser("john")
            .password("pa55word")
            .roles("USER");
        auth.inMemoryAuthentication().withUser("admin")
            .password("root123")
            .roles("USER","ADMIN");
    }
    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) 
            throws Exception {
        auth.userDetailsService(new ServicioUsuario(usuarioDB));
    
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/").permitAll()
            .antMatchers("/principal/**").access("hasROLE('USER')");
            
        http.formLogin().loginPage("/iniciarsesion")
            .usernameParameter("usuario").passwordParameter("contrasena");
        http.formLogin().defaultSuccessUrl("/principal")
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .logoutUrl("/salir")
            .and().csrf().disable();
        
    }
}
