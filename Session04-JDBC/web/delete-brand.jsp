<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Brand</title>
    </head>
    <body>
        <h1>Delete Brand</h1>
        <hr/>
        <form action="<c:url value="/brand/delete_handler.do"/>">
            Are you sure to delete this brand with id = ${param.id};
            <input type="hidden" name="id" value="${param.id}" />
            <button type="submit" name="op" value="yes" >Yes</button>
            <button type="submit" name="op" value="no" >No</button>
        </form>
    </body>
</html>
