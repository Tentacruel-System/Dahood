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
                        <form:form method="GET" action = "/Dahood/verPerfil" 
                                   id = "verperfil">
                        </form:form>
                        <input 
                            class="btn btn-primary btn-lg" 
                            form="verperfil"
                            value="Ver Perfil"
                            type="submit">
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Dahood/chat">Chat</a>
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
                        <h1>Dahood</h1>
                    </div>
                    <div class ="col-2 barraElementos">

                    </div>

                </div>
            </div>    
        </div>
    </body>
</html>
