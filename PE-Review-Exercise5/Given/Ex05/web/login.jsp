<%-- 
    Document   : HoaDNT
    Created on : NOVEMBER 1, 2022, 9:09:09 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <h1>Login information</h1>
        <form action="MainController">
            UserID: <br/>
            <input type="text" name="userid"><br/>
            Password: <br/>
            <input type="password" name="password"><br/>
            <input type="hidden" name="action" value="login">
            <button type="submit" name="op" value="login">Login</button> 
        </form>
        <i>${message}</i>
    </body>
    
</html>

