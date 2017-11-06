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
        <title>Chat WebSocket</title>
        <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
        <script src="/Dahood/js/stomp.js"></script>

            <!--<link  type="text/javascript" href="<c:url value="/js/stomp.js"/> ">-->
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
                var socket = new SockJS('/Dahood/chat');
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
                stompClient.send("/app/chat", {}, text,from);
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
        <div>
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
