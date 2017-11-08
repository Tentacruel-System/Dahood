<%-- 
    Document   : PantallaInicio
    Created on : Oct 31, 2017, 5:50:08 PM
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="GET" action = "/Dahood/iniciarsesion" 
                   id = "iniciarsesion">
        </form:form>
        <form:form method="GET" action = "/Dahood/crearPerfil" 
                   id = "crearperfil">
        </form:form>
        <table>
            <tr>
                <td colspan="2"><input type="submit" form ="iniciarsesion" 
                                        value = "Iniciar Sesión"/>
                </td>
                <td colspan="2"><input type="submit" form ="crearperfil"
                                        value="Crear Perfil"/>
                </td>
            </tr>
        </table>
    </body>
</html>
