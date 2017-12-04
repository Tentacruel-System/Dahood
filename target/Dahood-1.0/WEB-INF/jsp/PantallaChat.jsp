<%-- 
    Document   : chat-test
    Created on : 30 /10/2017, 01:19:40 PM
    Author     : maw & orlando
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Chat</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Inicio.css"/> ">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/Chat.css"/> ">
        <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
        <script src="/Dahood/js/stomp.js"></script>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    <nav class="navbar navbar-expand-lg navbar-dark" style = "background-color: black;">
        <a class="navbar-brand" href="/Dahood">Dahood</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/verPerfil">Ver perfil</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href = "/Dahood/principal/chat">Chat</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/buscar">Buscar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href = "/Dahood/principal/salir">Cerrar sesion</a>
                </li>
            </ul>
        </div>
    </nav>
    
    
    <script type="text/javascript">
        var stompClient = null;
        var Message;
        function setConnected(connected){
            document.getElementById('connect').disabled = connected;
            //document.getElementById('disconnect').disabled = !connect;
            document.getElementById('conversationDiv').style.visibility
                    = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }
        function connect() {
            var socket = new SockJS('/Dahood/principal/chat');
            socket.onopen = function() {
                sock.send('test');
            };
            socket.onmessage = function(e){
                sock.close();
            };
            socket.onclose = function() {
            };
            stompClient = Stomp.over(socket);
            stompClient.connect({},function(frame){
                setConnected(true);
                stompClient.subscribe('/topic/messages', function(messageOutput){
                    var side = 'left';
                    showMessageOutput(side,JSON.parse(messageOutput.body));
                });
            },function(error){
                console.log(error);
            });
        }
        function disconnect() {
            if(stompClient !==  null){
                stompClient.disconnect();
            }
            setConnected(false);
        }
        function showMessageOutput(arg,messageOutput){
            this.message_side = arg.message_side;
            //var response = document.getElementById('response');
            var $message;
           
            $message = $($('.message_template').clone().html());
             
            $message.addClass("message left ").find('.text').html(messageOutput.ruta);
            $('.messages').append($message);
            return setTimeout(function(){
                return $message.addClass('appeared');
            },0);
        };
        $(function (){
            var getMessageText, message_side, sendMessage;
            message_side = 'right';
            getMessageText = function (){
                var $message_input;
                $message_input = $('message_input');
                return $message_input.val();
                
            };
            sendMessage = function(){
                var $messages;
       
                var text = document.getElementById('text').value;
                
                stompClient.send("/app/principal/chat", {}, text, {});
      
                $('message_input').val('');
                $messages = $('.messages');
                message_side = message_side === 'left' ? 'right' : 'left';
                return $messages.animate({scrollTop: $messages.prop('scrollHeight')},300);
                stompClient.send("/app/principal/chat", {}, text, {});
            };
            $('.send_message').click(function (e){
                return sendMessage();
            });
            $('.message_input').keyup(function (e){
                if(e.which === 13){
                    return sendMessage();
                }
            });
        });
    </script>
    
</head>
<body id = "connect" onload="connect();">
    <div class="container-fluid principal">
        
        
        
        <div class="row content">
            <div class="col-sm-3 sidenav ">
                <h1 id = "from"> ${nickname}</h1>
                <div class="list-group">
                    <h5> Amigos </h5>
                    <a >
                        
                        <c:forEach var= "usuario" items ="${amigos}">
                            <h4 class="list-group-item list-group-item-action">${usuario.usuario}</h4>
                            
                        </c:forEach>
                    </a>
                </div>
            </div>
            
            
            
            <div class ="col-sm-9 nopadding">

                <div class="chat_window">
                    <div class="top_menu">
                        <div class="buttons">
                            <div class="button close"></div>
                            <div class="button minimize"></div>
                            <div class="button maximize"></div>
                            
                        </div><div class="title">Chat</div>
                        
                    </div>
                    <ul class="messages"></ul>
                    <div class="bottom_wrapper clearfix">
                        <div id="conversationDiv" class="message_input_wrapper">
                            <input  id= "text" class="message_input" placeholder="Type your message here..." />
                            <p id="response"></p>
                        </div>
                        
                        <div class="send_message">
                            <div class="icon"></div>
                            <div class="text">Send</div>
                            
                        </div>
                        
                    </div>
                    
                </div>
                
                
                <div class="message_template">
                    <li class="message">
                        <div class="avatar">
                            
                        </div>
                        
                        <div class="text_wrapper">
                            <div class="text">
                                
                            </div>
                            
                        </div>
                    </li>
                    
                </div>
                
                
            </div>
        </div>
    </div>
    
    
    
    
    
</body>
</html>
