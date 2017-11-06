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
    </head>
    <body>
        <div class="container-fluid principal">
            <header>
                <ul class="nav nav-pills nav-justified">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Ver Perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Chat</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Buscar</a>
                    </li>
                    <li class="nav-item">
                        <h1><a href="<c:url value="/salir"/>"> Salir</a></h1>
                    </li>
                </ul>
            </header>


            <div class ="container-fluid">
                <div class = "row">

                    <div class ="col-10 style" style = "padding-top: 1px">
                        <aside>
                            <h1> ${nombre}</h1>
                            <h2>${nickname} </h2>
                            <h2>${correo} </h2>
                        </aside>
                        <form:form method="GET" action = "/Dahood/eliminarPerfil" id = "eliminarPerfil" ></form:form>
                        <form:form method="GET" action = "/Dahood/vistaEditarPerfil" id = "editarperfil"></form:form>
                        <p class="lead">
                            <input type="submit" class="btn btn-primary btn-lg" form="eliminarPerfil" value ="Eliminar Perfil"/>
                            <input type="submit" class="btn btn-primary btn-lg" form ="editarperfil" value="Editar Perfil"/>
                        </p>
                        
                    </div>
                    <div class ="col-2 barraElementos">

                    </div>

                </div>
            </div>    
        </div>
    </body>
</html>