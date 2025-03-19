<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<c:if test="${account == null}">
    <c:redirect url="login.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
    </head>
    <body>
        <h1>Employee List</h1>
        <hr/>
        <!--your code here-->
        Welcome, ${account.fullName} |
        <a href="MainController?action=logout">Logout</a> | 
        <a href="MainController?action=create">Create</a>

        <form action="MainController">
            Employee name: <input type="text" name="fullName">
            <button type="submit" name="action" value="search">Search</button>
        </form>

        <table>
            <tr>
                <th>Id</th>
                <th>Full Name</th>
                <th>Date of Birth</th>
                <th>Salary</th>
                    <c:if test="${account.roleId == 'AM'}">
                    <th>Operation</th>
                    </c:if>
            </tr>

            <c:forEach var="em" items="${list}">
                <tr>
                    <td>${em.id}</td>
                    <td>${em.fullName}</td>
                    <td>
                        <fmt:formatDate value="${em.dob}" pattern="MM/dd/yyyy"/>
                    </td>
                    <td>
                        <fmt:formatNumber value="${em.salary}" type="currency"/>
                    </td>
                    <c:if test="${account.roleId == 'AM'}">
                        <td>
                            <a href="MainController?action=remove&id=${em.id}">Remove</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>

        <i>${message}</i>
    </body>
</html>
