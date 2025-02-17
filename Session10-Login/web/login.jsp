<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <hr/>
        <form action="<c:url value="/user/login.do"/>">
            Email: <hr/>
            <input type="email" name="email" value="${param.email}" />
            Password: <hr/>
            <input type="text" name="password" value="${param.password}" />
            <button type="submit" name="op" value="login">Submit</button>
            <button type="submit" name="op" value="cancel">Cancel</button>
        </form>
    </body>
</html>
