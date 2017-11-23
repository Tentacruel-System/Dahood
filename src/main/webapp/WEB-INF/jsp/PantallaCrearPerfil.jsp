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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Inicio.css"/> ">
        <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/journal/bootstrap.min.css" rel="stylesheet" integrity="sha384-1L94saFXWAvEw88RkpRz8r28eQMvt7kG9ux3DdCqya/P3CfLNtgqzMnyaUa49Pl2" crossorigin="anonymous">
        <title>Registrarse</title>
        
    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: black;">
        <a class="navbar-brand" href="/Dahood">Dahood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                
                <li class="nav-item">
                    <a class="nav-link" href="/Dahood/iniciarsesion">Iniciar Sesion</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/Dahood/crearPerfil">Registrar</a>
                </li>
                
            </ul>
            
        </div>
    </nav>
</head>
<body class = "body2">
    <div class = "register">
        <h1>Crear Perfil</h1>
        <div class = "scroll2">
            
            <!-- action contiene la carpeta del proyecto y el nombre de la peticion -->
            <form action="/Dahood/crearPerfil" method="post" >  
                <p>Nombre:</p>
                <input name="nombre" type="text" placeholder="...escribe tu nombre"/>
                <p>Apellido paterno:</p>
                <input name="apellido_p" type="text" placeholder="...escribe apellido paterno"/>
                <p>Apellido materno:</p>
                <input name="apellido_m" type="text" placeholder="...escribe apellido materno" />
                <p>Nickname:</p>
                <input name="nickname" type="text" placeholder="...elige un nickname" />
                <p>Correo:</p>
                <input name="correo" type="text" placeholder="...escribe tu correo" />
                <p>Contraseña:</p>
                <input name="contrasena" type="password" id="pass" class="pass" placeholder="...escribe tu contraseña"/>
                <p>Confirmar Contraseña:</p>
                <input name="confcontrasena" type="password" id="repass" class="repass" placeholder="escribe de nuevo tu contraseña"/>
        </div>
        <div class = "form-check scroll">
            <h3>Selecciona tus gustos</h3>
            <c:set var="numGustos" value="${gustos.size()}" scope="session" />
            <c:set var="gustosBD" value="${gustos}" scope="session"/>   
            
            <c:forEach begin="0" end="${Math.round((numGustos/6) - 1)}" var="i">
                
                <c:forEach begin="0" end = "5" var = "j">
                    
                    <input type="checkbox" class = "form-check-input" name="${gustosBD[i*6+j].nombre_gusto}" value ="${gustosBD[i*6+j].nombre_gusto}"/>
                    <p><c:out value= "${gustosBD[i*6+j].nombre_gusto}"/></p>
                    
                </c:forEach>
                
            </c:forEach>
            <c:if test="${(numGustos % 6) > 0}">
                
                <c:forEach begin="0" end="${(numGustos % 6) - 1}" var="k">
                    
                    <input type="checkbox" class = "form-check-input" name="${gustosBD[Math.round(numGustos / 6) * 6 + k].nombre_gusto}" value ="${gustosBD[(numGustos / 6) * 6 + k].nombre_gusto}"/>
                    <p><c:out value= "${gustosBD[Math.round(numGustos / 6) * 6 + k].nombre_gusto}"/></p>
                    
                </c:forEach>
                
            </c:if>
        </div>
        <input name="submit" type="submit" id="boton" value="Aceptar" class="boton"/>
    </form>
</div><!-- fin contenedor -->


</body>
</html>
