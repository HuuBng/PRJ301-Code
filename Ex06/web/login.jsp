<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <hr/>
        <!--your code here-->
        <form action="MainController">
            Email:<br/>
            <input type="text" name="email" required=""/><br/>
            Password:<br/>
            <input type="password" name="password" required=""/><br/>
            <button type="submit" name="action" value="login">Login</button>
        </form>
        <i>${message}</i>
    </body>
</html>
