<%-- 
    Document   : HoaDNT
    Created on : NOVEMBER 1, 2022, 9:09:09 PM
    Author     : hd
--%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car List Page</title>
    </head>
    <body>
        <!--your code here-->
        Welcome ${user.fullName} | 
        <a href="MainController?action=logout">Logout</a>

        <c:if test="${user.roleID == 'AD'}">
            <form action="MainController">
                Id: <br/>
                C-<input type="number" min="0" max="999" name="id" value="0"> <br/>
                Name: <br/>
                <input type="text" name="name"> <br/>
                Description: <br/>
                <input type="text" name="description"> <br/>
                Price: <br/>
                <input type="number" min="0" name="price" value="0"> <br/>
                Speed: <br/>
                <input type="number" min="0" name="speed" value="0"> <br/>
                <input type="hidden" name="status" value="true">
                <button type="submit" name="action" value="create">Create</button>
            </form>
        </c:if>

        <br/>
        <i>${message}</i>
        <br/>    

        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Speed</th>
                <th>Status</th>
            </tr>
            <c:forEach var="car" items="${list}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.name}</td>
                    <td>${car.description}</td>
                    <td><fmt:formatNumber type="currency" value="${car.price}"/></td>
                    <td>${car.speed}</td>
                    <td>
                        <c:if test="${car.status == 'true'}">
                            1
                        </c:if>
                        <c:if test="${car.status == 'false'}">
                            0
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
