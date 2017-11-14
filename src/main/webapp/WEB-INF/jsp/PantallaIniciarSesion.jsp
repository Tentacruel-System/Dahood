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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/journal/bootstrap.min.css" rel="stylesheet" integrity="sha384-1L94saFXWAvEw88RkpRz8r28eQMvt7kG9ux3DdCqya/P3CfLNtgqzMnyaUa49Pl2" crossorigin="anonymous">
        <title>JSP Page</title>
        
    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: black;">
        <a class="navbar-brand" href="/Dahood">Dahood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                
                <li class="nav-item active">
                    <a class="nav-link" href="/Dahood/iniciarsesion">Iniciar Sesion</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Dahood/vistaCrearPerfil">Registrar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
            </ul>
            
        </div>
    </nav>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    <form:form method="POST" action = "/Dahood/iniciarsesion" >
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
                    <input name="submit" type="submit" value="Iniciar Sesión"/>
                </td>
            </tr>
        </table>
    </form:form>
</html>
