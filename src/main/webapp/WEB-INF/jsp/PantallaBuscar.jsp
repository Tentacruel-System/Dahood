<%-- 
    Document   : PantallaBuscar
    Created on : Nov 8, 2017, 6:59:36 PM
    Author     : jesus
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
        <title>Encontrar Amigos</title>
    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: black;">
        <a class="navbar-brand" href="/Dahood">Dahood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/verPerfil">Ver perfil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/chat">Chat</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href = "/Dahood/principal/buscar">Buscar</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link " href = "/Dahood/principal/salir">Cerrar sesion</a>
                </li>
            </ul>
        </div>
    </nav>
</head>
<body>
    <div class="container-fluid principal">  
        <div class ="container-fluid">
            <div class = "row">
                <div class ="col-8 ">
                    <div class="container-fluid bordeChat" style="overflow: scroll">
                        
                        <header class="headerchat bordebot">
                            
                            Personas con intereses en común
                            
                        </header>
                        
                        <div class = "row">
                            
                            <%--  <div class="col-2 bordeRigth">Amigos</div>   --%>                                                                    
                            <div class ="col-8">
                                <div class="container-fluid">                                        
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Nickname</th>
                                                <th>Nombre</th>
                                                <th>Correo</th>
                                                <th>Compatibilidad</th>
                                                <th>Gustos</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="pareja" items="${usuarios}">
                                            <tbody>                                                   
                                            <th>${pareja.usuario.nickname}</th>
                                            <th>${pareja.usuario.nombre}</th>
                                            <th>${pareja.usuario.correo}</th>
                                            <th>${pareja.compatibilidad * 100}</th>
                                                <c:forEach var="gusto" items="${pareja.usuario.gustos}">
                                                <th>${gusto.nombre_gusto}</th>
                                                </c:forEach>
                                            </tbody>
                                            
                                        </c:forEach>
                                    </table>
                                    
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
                
                <div class ="col-8">
                    
                </div>
            </div>
        </div>    
    </div>
</body>
</html>
