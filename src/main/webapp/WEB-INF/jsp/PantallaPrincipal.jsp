<%-- 
Document   : PantallaPrincipal
Created on : Nov 6, 2017, 12:29:00 PM
Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Inicio.css"/> ">
        <title>Principal</title>
    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: black;">
        <a class="navbar-brand" href="/Dahood">Dahood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                
                <li class="nav-item active">
                    
                    <a class="nav-link" href = "/Dahood/principal/verperfil">Perfil</a>
                </li>
                <li class="nav-item">
                   
                    <a class="nav-link" href = "/Dahood/principal/chat">Chat</a>
                </li>
                
                <li class="nav-item">
                    
                    <a class="nav-link" href = "/Dahood/principal/buscar">Buscar Amigos</a>
                </li>
                
                <li class="nav-item">
                    
                    <a class="nav-link" href = "/Dahood/principal/salir">Cerrar sesion</a>
                </li>
                
            </ul>
            
        </div>
    </nav>
</head>
<body>
    
</body>
</html>
