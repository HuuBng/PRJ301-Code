<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--header--%>
        <h1 style="color: red">FrontController - Layout - JDBC - Demo</h1>
        <hr/>
        <%--content--%>
        <jsp:include page="/WEB-INF/${controller}/${action}.jsp" />
        <%--footer--%>
        <hr/>
        Copyright &COPY; by FPT students
    </body>
</html>
