<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Brand</title>
    </head>
    <body>
        <h1>Create Brand</h1>
        <hr/>
        <form action="<c:url value="/brand/create_handler.do"/>">
            Id: <br/>
            <input type="text" name="id" value="${param.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value="${param.name}"/> <br/>
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
</html>
