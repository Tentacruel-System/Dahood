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
<body class = "body2">
    
    <div class="container-fluid principal buscar">  
        <div class ="container-fluid">
            <div class = "cajita">
                <div class ="col-10">
                    <div class="container-fluid bordeChat">
                        
                        <header class="headerchat bordebot">
                            
                            <h1>Personas con intereses en común</h1>
                            
                        </header>
                        
                        <div class = "row">
                            
                            <%--  <div class="col-2 bordeRigth">Amigos</div>   --%>                                                                    
                            <div class ="col-10">
                                <div class="container-fluid">
                                    <table class ="table">
                                        <thead>
                                            <tr>
                                                <th><p>Nickname</p></th>
                                                <th><p>Nombre</p></th>
                                                <th><p>Correo</p></th>
                                                <th><p>Compatibilidad</p></th>
                                                <th><p>Gustos</p></th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="pareja"  items="${usuarios}">
                                            <tbody class="boxy">                                                   
                                            <th class="white">${pareja.usuario.nickname}</th>
                                                <th class="white">${pareja.usuario.nombre}</th>
                                                <th class="white">${pareja.usuario.correo}</th>
                                                <th class="white">${pareja.compatibilidad * 100}</th>
                                                <th style="overflow-y: scroll; height: 40px!important">
                                                <c:forEach var="gusto" items="${pareja.usuario.gustos}">
                                                    <li class="white">${gusto.nombre_gusto}</li>
                                                </c:forEach>
                                                </th>
                                                    <th><form action="/Dahood/principal/agregarAmigo" method="POST">                                                        
                                                            <input id="id_usuario" name="id_usuario" hidden="true" value="${pareja.usuario.idUsuario}"><br>
                                                            <!--<input id="nombre" name="nombre"   placeholder="${pareja.usuario.idUsuario}"><br>-->
                                                            <!--<button type="submit" class="btn btn-primary btn-lg active">Agregar</button>-->
                                                            <input name="submit" type="submit" id="boton" value="Agregar" class="boton"/>
                                                            </form></th>
                                            </tbody>
                                            
                                        </c:forEach>
                                    </table>
                                    
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
              
            </div>
        </div>    
    </div>
</body>
</html> 