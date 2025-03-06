<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>forTokens</h1>
        <hr/>
        <c:forTokens var="word" items="I am learning about JSTL" delims=" " >
            ${word} <br/>
        </c:forTokens>
    </body>
</html>
