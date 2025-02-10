<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo</title>
    </head>
    <body>
        <h1>FrontController Demo</h1>
        <hr/>
        <h3>User</h3>
        <a href="<c:url value="/user/register.do" />">Register</a><br/>
        <a href="<c:url value="/user/login.do" />">Login</a><br/>
        <a href="<c:url value="/user/logout.do" />">Logout</a><br/>
    </body>
</html>
