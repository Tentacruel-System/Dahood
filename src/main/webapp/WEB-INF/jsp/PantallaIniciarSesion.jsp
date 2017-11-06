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
                    <form:form class="iniciarsesion" method="POST" action = "/Dahood/iniciarsesion">
                        <table>
                            <tr>
                                <td>User:</td>
                                <td><input type='text' name='usuario' value=''></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type='password' name='contrasena'/></td>
                            </tr>
                            <tr>
                                <td colspan='2'> 
                                <input class="btn btn-primary btn-lg" name="submit" type="submit" value="Iniciar Sesión"/>
                                </td>
                            </tr>
                         </table>
                    </form:form>
            </div>
        </div>
         <footer class ="footer">    
        sdasdadasd
        </footer>
    </body>
</html>
