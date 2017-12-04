    <%-- 
    Document   : PantallaPrincipal
    Created on : Nov 6, 2017, 12:29:00 PM
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Ver perfil</title>
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
                    <c:set var="numGustos" value="${gustos.size()}"  scope="session" /> 
                    <c:set var="gustosBD" value="${gustos}" scope="session"/>   
                    <div class ="col-10 style" style = "padding-top: 1px">
                        <aside>
                            <h1>${nombre}</h1>
                            <h2>${nickname}</h2>
                            <h2>${correo} </h2>
                            <table>
                                <c:if test = "${Math.floor((numGustos/6) - 1)} > 0">
                                    <c:forEach begin="0" end="${Math.floor((numGustos/6) - 1)}" var="i">
                                       <tr>
                                       <c:forEach begin="0" end = "5" var = "j">
                                           <td>
                                               <c:out value= "${gustosBD[i*6+j]}"/>
                                           </td>
                                       </c:forEach>
                                       </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test= "${(numGustos % 6) > 0}">
                                    <tr>   
                                        <c:forEach begin="0" end="${(numGustos % 6) - 1}" var="k">
                                            <td>
                                                <c:out value= "${gustosBD[Math.floor(numGustos / 6) * 6 + k]}"/>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                </c:if>
                            </table>
                        </aside>
                        <form:form method="GET" action = "/Dahood/principal/confirmarEliminarPerfil" id = "eliminarPerfil" ></form:form>
                        <form:form method="GET" action = "/Dahood/principal/editarPerfil" id = "editarperfil"></form:form>
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
