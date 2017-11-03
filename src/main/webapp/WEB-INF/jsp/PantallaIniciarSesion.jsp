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
    </head>
    <body>
        <h1>Iniciar Sesión</h1>
        <form:form method="GET" action = "/Dahood/principal" >
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
