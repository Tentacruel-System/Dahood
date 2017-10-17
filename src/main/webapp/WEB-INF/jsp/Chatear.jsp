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
        <div class="container">
            <header>Hola mundo</header>
            <div class ="container">
                <div class = "row">
                    <div class ="col-2">
                        Perfil  <br>
                        Buscar  <br>
                        Chat    <br>
                        Salir   <br>
                    </div>
                    <div class ="col-8">
                        <div class="container">
                        <header>Chat</header>

                            <div class = "row">

                                <div class="col-2"> 
                                <header>Amigos</header>
                                Amigo1 <br>
                                Amigo2 <br>
                                Amigo3 <br>
                                </div>

                                <div class =" col-8">
                                    <div class="container">
                                        
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
