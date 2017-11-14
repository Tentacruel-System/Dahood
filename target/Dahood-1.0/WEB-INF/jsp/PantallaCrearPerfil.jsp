<%-- 
    Document   : nuevoInicio
    Created on : Oct 2, 2017, 3:40:59 PM
    Author     : lgallo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/cear_perfilcss.css"/> ">
        <title>Crear Perfil</title>
    </head>
    <body>
        
        <div id="envoltura">
        <div id="contenedor">
 
            <div id="cabecera">
                <h2>Crear Perfil</h2>
            </div>
 
            <div id="cuerpo">
                <!-- action contiene la carpeta del proyecto y el nombre de la peticion -->
                <form action="/Dahood/crearPerfil" method="post" >  
                    <p><label for="nombre">Nombre:</label>
                    <input name="nombre" type="text" placeholder="...escribe tu nombre" autofocus=""/></p>
                    
                    <p><label for="apellido_p">Apellido paterno:</label>
                    <input name="apellido_p" type="text" placeholder="...escribe apellido paterno" /></p>
                    
                    <p><label for="apellido_m">Apellido materno:</label>
                    <input name="apellido_m" type="text" placeholder="...escribe apellido materno" /></p>
                    
                    <p><label for="nickname">Nickname:</label>
                    <input name="nickname" type="text" placeholder="...elige un nickname" /></p>
                    
                    <p><label for="correo">Correo:</label>
                    <input name="correo" type="text" placeholder="...escribe tu correo" /></p>
                    
                    <p><label for="contrasena">Contraseña:</label>
                    <input name="contrasena" type="password" id="pass" class="pass" placeholder="...escribe tu contraseña"/></p>
 
                    <p><label for="confcontrasena">Confirmar Contraseña:</label>
                    <input name="confcontrasena" type="password" id="repass" class="repass" placeholder="escribe de nuevo tu contraseña"/></p>
                    <c:set var="numGustos" value="${gustos.size()}" scope="session" />
                    <c:set var="gustosBD" value="${gustos}" scope="session"/>   
                    <table>
                        <c:forEach begin="0" end="${Math.round((numGustos/6) - 1)}" var="i">
                           <tr>
                           <c:forEach begin="0" end = "5" var = "j">
                               <td>
                                   <input type="checkbox" name="${gustosBD[i*6+j].nombre_gusto}" value ="${gustosBD[i*6+j].nombre_gusto}"/>
                                   <c:out value= "${gustosBD[i*6+j].nombre_gusto}"/>
                               </td>
                           </c:forEach>
                           </tr>
                        </c:forEach>
                        <c:if test="${(numGustos % 6) > 0}">
                            <tr>  
                                <c:forEach begin="0" end="${(numGustos % 6) - 1}" var="k">
                                    <td>
                                        <input type="checkbox" name="${gustosBD[Math.round(numGustos / 6) * 6 + k].nombre_gusto}" value ="${gustosBD[(numGustos / 6) * 6 + k].nombre_gusto}"/>
                                        <c:out value= "${gustosBD[Math.round(numGustos / 6) * 6 + k].nombre_gusto}"/>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:if>
                    </table>
                    <p><button name="submit" type="submit" id="boton" value="Aceptar" class="boton">Aceptar</button></p>
                </form>
            
            </div>
            <div id="pie">DAHOOD</div>
        </div><!-- fin contenedor -->
 
    </div>
        
    </body>
</html>
