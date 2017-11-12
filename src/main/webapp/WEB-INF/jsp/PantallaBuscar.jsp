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
        <title>Buscar</title>
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
                                                </tr>
                                            </thead>
                                            <c:forEach var="pareja" items="${usuarios}">
                                                <tbody>                                                   
                                                    <th>${pareja.u.nickname}</th> 
                                                    <th>${pareja.compatibilidad}</th>
                                                    <th>${pareja.u.correo}</th>
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
