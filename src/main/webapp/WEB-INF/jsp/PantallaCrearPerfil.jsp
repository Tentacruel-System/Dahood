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
        <title>Crear perfil</title>

    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: black;">
        <a class="navbar-brand" href="/Dahood">Dahood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
    <script>
        function validar(esto) {
            valido = false;
            for (a = 0; a < esto.elements.length; a++) {
                if (esto[a].type == "checkbox" && esto[a].checked == true) {
                    valido = true;
                    break
                }
            }
            if (!valido) {
                alert("Seleccione al menos una casilla");
                return false
            }
        }
    </script>
</head>
<body class = "body2">
    <div class = "register">
        <h1>Crear Perfil</h1>
        <div>

            <!-- action contiene la carpeta del proyecto y el nombre de la peticion -->
            <form action="/Dahood/crearPerfil" method="post" onsubmit="return validar(this)">
                <input name="nombre" type="text" placeholder="Nombre" required/>
                <input name="apellido_p" type="text" placeholder="Apellido paterno" required/>
                <input name="apellido_m" type="text" placeholder="Apellido materno" />
                <input name="nickname" type="text" placeholder="Nickname" required/>
                <input name="correo" type="text" placeholder="Correo" pattern="^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$" title="Escribe una dirección de correo válida" required/>
                <input name="contrasena" type="password" id="pass" class="pass" placeholder="Contraseña" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Debe contener al menos un número, una mayúscula, una minúscula, y al menos 8 caracteres" required/>
        </div>
        <div class = "form-check scroll">
            <h3>Selecciona tus gustos</h3>
            <c:set var="numGustos" value="${gustos.size()}" scope="session" />
            <c:set var="gustosBD" value="${gustos}" scope="session"/>   

            <c:forEach begin="0" end="${numGustos-1}" var="i">
                <input type="checkbox" class = "form-check-input" name="${gustosBD[i].nombre_gusto}" value ="${gustosBD[i].nombre_gusto}"/>
                <p><c:out value= "${gustosBD[i].nombre_gusto}"/></p>
            </c:forEach>
        </div>
        <input name="submit" type="submit" id="boton" value="Aceptar" class="boton"/>
    </form>
    <form:form method="GET" action = "/Dahood" id = "cancelar"></form:form>
    <p class="lead">
        <input type="submit" class="btn btn-primary btn-lg" form ="cancelar" value="Cancelar"/>
    </p>
</div><!-- fin contenedor -->


</body>
</html>
