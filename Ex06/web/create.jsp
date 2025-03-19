<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${account == null}">
    <c:redirect url="login.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating Employee</title>
    </head>
    <body>
        <h1>Creating Employee</h1>
        <hr/>
        <!--your code here-->
        
        <form action="MainController">
            <input type="hidden" name="action" value="create_handler"/>
            Id: <br/>
            <input type="text" disabled="" /> <br/>
            Full Name: <br/>
            <input type="text" name="fullName"> <br/>
            Date of Birth: <br/>
            <input type="date" name="dob"> <br/>
            Salary: <br/>
            <input type="number" name="salary" min="0" value="0">
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        
    </body>
</html>
