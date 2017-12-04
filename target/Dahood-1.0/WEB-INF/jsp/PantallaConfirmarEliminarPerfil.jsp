<%-- 
    Document   : PantallaConfirmarEliminarPerfil
    Created on : Nov 30, 2017, 5:40:51 PM
    Author     : manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar eliminar perfiles</title>
        <link rel="stylesheet" 
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
              integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" 
              crossorigin="anonymous">
        <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/journal/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-1L94saFXWAvEw88RkpRz8r28eQMvt7kG9ux3DdCqya/P3CfLNtgqzMnyaUa49Pl2" 
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/confirmarEliminarPerfil.css"/>">
    </head>
    <body class="body2">
        <form:form method="POST" action = "/Dahood/principal/eliminarPerfil" 
               id = "eliminarPerfil">
        </form:form>
        <form:form method="GET" action = "/Dahood/principal/verPerfil"
                   id = "verPerfil">
        </form:form>
        <div class="login">
            <h1>Confirma eliminar perfil</h1>
            <input type='password' form="eliminarPerfil" name="contrasena" placeholder = "Contraseña" 
                   required
                   oninvalid = "this.setCustomValidity('Llena este campo')"
                   oninput="setCustomValidity('')"/>
            <c:if test="${not empty errorConfirmacionContrasena}">
                <div class="alert alert-danger">
                    <strong>Error:</strong> ${errorConfirmacionContrasena}
                </div>
            </c:if>
            <input 
                form="eliminarPerfil"
                value="Aceptar"
                type="submit">
            <input 
                type="submit" 
                form ="verPerfil"
                value="Cancelar"/>
        </div>
    </body>
</html>
