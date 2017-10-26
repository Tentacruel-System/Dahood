<%-- 
    Document   : Chatear
    Created on : 16/10/2017, 06:18:32 PM
    Author     : orlando
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid principal">
            <header>
                <ul class="nav nav-pills nav-justified">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Active</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Longer nav link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
            </header>
                
                
            <div class ="container-fluid">
                <div class = "row">
                    <div class ="col-2 barraElementos">
                        <button type="button" class="btn btn-outline-primary espaciado">Perfil</button> <br>
                        <button type="button" class="btn btn-outline-primary espaciado">Buscar</button> <br>
                        <button type="button" class="btn btn-outline-primary espaciado">Chat</button> <br>
                        <button type="button" class="btn btn-outline-primary espaciado">Salir</button> <br>
                    </div>
                    <div class ="col-8 ">
                        <div class="container-fluid bordeChat">
                            
                            <header class="headerchat bordebot">
                                
                                Chat
                                    
                            </header>
                                
                            <div class = "row">
                                
                                <div class="col-2 bordeRigth">Amigos</div>
                                    
                                    
                                    
                                <div class =" col-8">
                                    <div class="container-fluid">
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