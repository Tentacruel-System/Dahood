<%-- 
    Document   : PantallaIniciarSesion
    Created on : Oct 31, 2017, 5:30:49 PM
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" 
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" 
            integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" 
            crossorigin="anonymous">
        <link 
            rel="stylesheet" 
            type="text/css" 
            href='<c:url value="/css/Inicio.css"/>'/>
        <link
            rel="stylesheet"
            type="text/css"
            href="<c:url value="/css/IniciarSesion.css"/>"/>
    </head>
    <body id="grad2">
        <nav class="navbar navbar-light bg-faded">
            <a class="navbar-brand" href="#">
                <img src="/assets/brand/bootstrap-solid.svg" 
                width="30" 
                height="30" 
                class="d-inline-block align-top" alt="">
                Bootstrap
            </a>
        </nav>
        <div class="container-fluid">
            <div class="jumbotron transparente">
                <h1 class="display-1">Dahood</h1>
                <p class="lead">La red social para los nuevos amigos.</p>
                <hr class="my-4">
                <div class="row">
                    <div class="form">
                        <form:form method="POST" action="/Dahood/iniciarsesion" id="loginForm">
                            <div class="form-group input-group">
                                <input class="form-control" type="text" name='usuario' placeholder="Usuario"/>          
                            </div>
                            <div class="form-group input-group">
                                <input class="form-control" type="password" name='contrasena' placeholder="Contrasena"/>     
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary btn-lg" value="Iniciar Sesión"/>
                            </div>
                        </form:form>         
                    </div>    
                </div>
            </div>
        </div>
        <div>
            <div class="card-deck">
                <div class="card">
                    <img class="card-img-top" src="https://www.codeproject.com/KB/GDI-plus/ImageProcessing2/img.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h4 class="card-title">Card title</h4>
                        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>

                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="https://www.pets4homes.co.uk/images/breeds/13/large/8ce9e11b525195deba17fd91883b1601.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h4 class="card-title">Card title</h4>
                        <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>

                    </div>
                </div>
                <div class="card">
                    <img class="card-img-top" src="http://i.imgur.com/AkTtU0c.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h4 class="card-title">Card title</h4>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>

                    </div>
                </div>
            </div>
        </div>
         <footer class ="footer">    
        sdasdadasd
        </footer>
    </body>
</html>
