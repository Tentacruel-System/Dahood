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
                        <form:form method="GET" action = "/Dahood/principal/verPerfil" 
                                   id = "verperfil">
                        </form:form>
                        <input 
                            class="btn btn-primary btn-lg" 
                            form="verperfil"
                            value="Ver Perfil"
                            type="submit">
                    </li>
                    <li class="nav-item">
                        <form:form method="GET" action = "/Dahood/principal/chat" 
                                   id = "chat">
                        </form:form>
                        <input 
                            class="btn btn-primary btn-lg" 
                            form="chat"
                            value="Chat"
                            type="submit">
                    </li>
                    <li class="nav-item">
                        <form:form method="GET" action = "/Dahood/principal/buscar" 
                                   id = "buscar">
                        </form:form>
                        <input 
                            class="btn btn-primary btn-lg" 
                            form="buscar"
                            value="Buscar"
                            type="submit">
                    </li>
                    <li class="nav-item">
                         <form:form method="GET" action = "/Dahood/principal/salir" 
                                   id = "salir">
                        </form:form>
                        <input 
                            class="btn btn-primary btn-lg" 
                            form="salir"
                            value="Salir"
                            type="submit">
                    </li>
                </ul>
            </header>
            
            
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
                                <c:forEach begin="0" end="${Math.round((numGustos/6) - 1)}" var="i">
                                   <tr>
                                   <c:forEach begin="0" end = "5" var = "j">
                                       <td>
                                           <c:out value= "${gustosBD[i*6+j].nombre_gusto}"/>
                                       </td>
                                   </c:forEach>
                                   </tr>
                                </c:forEach>
                                <c:if test= "${numGustos % 6} > 0}">
                                    <tr>   
                                        <c:forEach begin="0" end="${(numGustos % 6) - 1}" var="k">
                                            <td>
                                                <c:out value= "${gustosBD[Math.round(numGustos / 6) * 6 + k].nombre_gusto}"/>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                </c:if>
                            </table>
                        </aside>
                        <form:form method="GET" action = "/Dahood/principal/eliminarPerfil" id = "eliminarPerfil" ></form:form>
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
