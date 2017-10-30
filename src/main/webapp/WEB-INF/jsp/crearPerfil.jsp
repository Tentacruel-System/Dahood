<%-- 
    Document   : nuevoInicio
    Created on : Oct 2, 2017, 3:40:59 PM
    Author     : lgallo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/cear_perfilcss.css"/> ">
        <title>Crear Perfil</title>
    </head>
    <body>
        
        <div id="envoltura">
        <div id="contenedor">
 
            <div id="cabecera">
                <h2>Crear Perfil</h2>
            </div>
 
            <div id="cuerpo">
 
                <form id="form-login" action="/Dahood/crearPerfil" method="post" >
                    
                    <p><label for="nombre">Nombre:</label></p>
                    <p><input name="nombre" type="text" class="" placeholder="...escribe tu nombre" autofocus=""/ ></p>
                    
                    <p><label for="apellido_p">Apellido paterno:</label></p>
                    <p><input name="apellido_p" type="text" class="" placeholder="...escribe apellido paterno" /></p>
                    
                    <p><label for="apellido_m">Apellido materno:</label></p>
                    <p><input name="apellido_m" type="text" class="" placeholder="...escribe apellido materno" /></p>
                    
                    <p><label for="nickname">Nickname</label></p>
                    <p><input name="nickname" type="text" class="" placeholder="...elige un nickname" /></p>
                    
                    <p><label for="correo">Correo</label></p>
                    <p><input name="correo" type="text" class="" placeholder="...escribe tu correo" /></p>
                    
                    <p><label for="contrasena">Contraseña:</label></p>
                    <p><input name="contrasena" type="password" id="pass" class="pass" placeholder="...escribe tu contraseña"/ ></p>
 
                    <p><label for="confcontrasena">Confirmar Contraseña:</label></p>
                    <p><input name="confcontrasena" type="password" id="repass" class="repass" placeholder="Repite contraseña" /></p>

                    <p id="bot"><button name="submit" type="submit" id="boton" value="Aceptar" class="boton">Aceptar</button></p>
                </form>
            </div>
 
            <div id="pie">DAHOOD</div>
        </div><!-- fin contenedor -->
 
    </div>
        
    </body>
</html>
