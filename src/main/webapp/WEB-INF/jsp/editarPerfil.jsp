<%-- 
    Document   : Editar Perfil
    Created on : Oct 2, 2017, 3:40:59 PM
    Author     : lgallo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Editar Perfil</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/"/> ">
        
    </head>
    <body>
        
        <div class="container">
        <div class="">
 
            <div class="">
                <h2>Editar Perfil</h2>
            </div>
 
            <div class="">
                <!-- action contiene la carpeta del proyecto y el nombre de la peticion -->
                <form action="/Dahood/editarPerfil" method="post" >
                    
                    <p><label for="nombre">Nombre:</label>
                    <input name="nombre" type="text" placeholder="...escribe tu nombre" autofocus=""/></p>
                    
                    <p><label for="apellido_p">Apellido paterno:</label>
                    <input name="apellido_p" type="text" placeholder="...escribe apellido paterno" /></p>
                    
                    <p><label for="apellido_m">Apellido materno:</label>
                    <input name="apellido_m" type="text" placeholder="...escribe apellido materno" /></p>
                    
                    <p><label for="nickname">Nickname:</label>
                    <input name="nickname" type="text" placeholder="...elige un nickname" /></p>
                    
                    <p><label for="correo">Correo:</label>
                    <input name="correo" type="text" placeholder="...escribe tu correo" /></p>
                    
                    <p><label for="foto">Foto:</label>
                    <input name="foto" type="text" placeholder="...agrega una foto" /></p>
                    
                    <p><label for="contrasena">Contraseña:</label>
                    <input name="contrasena" type="password" id="pass" class="pass" placeholder="...escribe tu contraseña"/></p>
 
                    <p><label for="confcontrasena">Confirmar Contraseña:</label>
                    <input name="confcontrasena" type="password" id="repass" class="repass" placeholder="escribe de nuevo tu contraseña"/></p>

                    <p><button name="submit" type="submit" id="boton" value="Aceptar" class="boton">Aceptar</button></p>
                </form>
            </div>
 
            <div class="">DAHOOD</div>
        </div><!-- fin contenedor -->
 
    </div>
        
    </body>
</html>
