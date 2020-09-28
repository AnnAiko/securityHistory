<%-- 
    Document   : message
    Created on : 26.09.2020, 16:00:19
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message</title>
    </head>
    <body>
    <center>
        <h3>${requestScope.message}</h3>
        <p><a href='/Securities/'>&larr; </a>
    </center>
</body>
</html>
