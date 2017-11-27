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
        <title>Editar perfil</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Inicio.css"/> ">
        <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
        <script src="/Dahood/js/stomp.js"></script>
        
    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: black;">
        <a class="navbar-brand" href="/Dahood">Dahood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href = "/Dahood/principal/verPerfil">Ver perfil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/chat">Chat</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/buscar">Buscar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/salir">Cerrar sesion</a>
                </li>
            </ul>
        </div>
    </nav>
    </head>
    <body>
        <div class="container-fluid principal">
            <div class ="container-fluid">
                <div class = "row">

                    <div class ="col-10 style" style = "padding-top: 1px">
                        <div id="envoltura">
                            <div id="contenedor">

                                <div id="cabecera">
                                    <h2>Editar Perfil</h2>
                                </div>

                                <div id="cuerpo">
                                    <!-- action contiene la carpeta del proyecto y el nombre de la peticion -->
                                    <form action="/Dahood/principal/editarPerfil" method="post" >

                                        <p><label for="nombre">Nombre:</label>
                                            <input name="nombre" type="text" placeholder="...escribe tu nombre" autofocus=""/></p>

                                        <p><label for="apellido_p">Apellido paterno:</label>
                                            <input name="apellido_p" type="text" placeholder="...escribe apellido paterno" /></p>

                                        <p><label for="apellido_m">Apellido materno:</label>
                                            <input name="apellido_m" type="text" placeholder="...escribe apellido materno" /></p>

                                        <p><label for="correo">Correo:</label>
                                            <input name="correo" type="text" placeholder="...escribe tu correo"/></p>

                                        <p><label for="contrasena">Contraseña:</label>
                                            <input name="contrasena" type="password" id="pass" class="pass" placeholder="...escribe tu contraseña"/></p>

                                        <p><label for="confcontrasena">Confirmar Contraseña:</label>
                                            <input name="confcontrasena" type="password" id="repass" class="repass" placeholder="escribe de nuevo tu contraseña"/></p>

                                        <p><button name="submit" type="submit" id="boton" value="Aceptar" class="boton">Aceptar</button></p>
                                    </form>
                                </div>
                            </div><!-- fin contenedor -->
                        </div>
                    </div>
                    <div class ="col-2 barraElementos">
                        Barra Lateral
                    </div>
                </div>    
            </div>
        </div>
    </body>
</html>

