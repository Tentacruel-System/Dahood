<%-- 
    Document   : 
    Created on : 16/10/2017, 03:17:28 PM
    Author     : maw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <title>Start Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/journal/bootstrap.min.css" rel="stylesheet" integrity="sha384-1L94saFXWAvEw88RkpRz8r28eQMvt7kG9ux3DdCqya/P3CfLNtgqzMnyaUa49Pl2" crossorigin="anonymous">    <link rel="stylesheet" type="text/css" href="<c:url value="/css/Inicio.css"/> ">
<nav class="navbar navbar-expand-lg navbar-dark lol">
    <a class="navbar-brand" href="/Dahood">Dahood</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    
</nav>
</head>
<body id ="grad2" >
    <form:form method="GET" action = "/Dahood/iniciarsesion" 
               id = "iniciarsesion">
    </form:form>
    <form:form method="GET" action = "/Dahood/crearPerfil" 
               id = "crearperfil">
    </form:form>
    <div class = "container-fluid">
        <div class="jumbotron" >
            <c:if test="${not empty perfilEliminado1}">
                <div class="alert alert-info">
                    ${perfilEliminado1}
                </div>
            </c:if>
            <c:if test="${not empty exito && empty perfilEliminado1}">
                <div class="alert alert-info">
                    ${exito}
                </div>
            </c:if>
            <h1 class="display-3">Dahood</h1>
            <p style = "text-align: center;">La red social para los nuevos amigos.   </p>
            <hr class="my-4">
            
            <p class="lead">
                <input 
                    class="btn btn-primary btn-lg" 
                    form="iniciarsesion"
                    value="Iniciar sesión"
                    type="submit">
                <input 
                    type="submit" 
                    form ="crearperfil"
                    class="btn btn-primary btn-lg"                
                    value="Crear Perfil"/>
            </p>
        </div>
        
        
        
    </div>
    <div class = "container-fluid">
        
        <div class="card-deck" >
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
</body>

