<%-- 
    Document   : chat-test
    Created on : 30/10/2017, 01:19:40 PM
    Author     : maw
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chat</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Inicio.css"/> ">
        <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
        <script src="/Dahood/js/stomp.js"></script>
        
    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: black;">
        <a class="navbar-brand" href="/Dahood">Dahood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/verperfil">Perfil</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href = "/Dahood/principal/chat">Chat</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/buscar">Buscar Amigos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/salir">Cerrar sesion</a>
                </li>
            </ul>
        </div>
    </nav>
    <script type="text/javascript">
            
            
        var stompClient = null;
          
        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility 
                    = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }
             
        function connect() {
            var socket = new SockJS('/Dahood/principal/chat');
            socket.onopen = function() {
                console.log('open');
                sock.send('test');
            };

            socket.onmessage = function(e) {
                console.log('message', e.data);
                sock.close();
            };

            socket.onclose = function() {
                console.log('close');
            };
            console.log(socket)
                
            stompClient =  Stomp.over(socket);  
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/messages', function(messageOutput) {
                    console.log(messageOutput)
                    showMessageOutput(JSON.parse(messageOutput.body));
                });
            },function(error) {
                // display the error's message header:
                console.log(error);
            });
        }
             
        function disconnect() {
            if(stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }
             
        function sendMessage() {
            var from = document.getElementById('from').value;
            var text = document.getElementById('text').value;
            console.log('Soy un console log:',from, text)
            stompClient.send("/app/principal/chat", {}, text,from);
        }
             
        function showMessageOutput(messageOutput) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(messageOutput.id_usuario1 + ": " 
                    + messageOutput.ruta + " (" + messageOutput.fecha + ")"));
            response.appendChild(p);
        }
    </script>
</head>
<body onload="disconnect()">
    <div class="container-fluid principal">
        
        <div>
            <input type="text" id="from" placeholder="Choose a nickname"/>
        </div>
        <br />
        <div>
            <button id="connect" onclick="connect();">Connect</button>
            <button id="disconnect" disabled="disabled" onclick="disconnect();">
                Disconnect
            </button>
        </div>
        <br />
        <div id="conversationDiv">
            <input type="text" id="text" placeholder="Write a message..."/>
            <button id="sendMessage" onclick="sendMessage();">Send</button>
            <p id="response"></p>
        </div>
    </div>          
</body>
</html>
