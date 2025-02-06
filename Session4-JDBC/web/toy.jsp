<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" />
<!--Tieng viet thi "vi-VN" -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Toy CRUD</title>
    </head>
    <body>
        <h1>Toy Crud </h1>
        <hr/>
        <a href="<c:url value="/toy/create.do"/>">Create New</a><br/>
        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th style="text-align: right">Price</th>
                <th>Expired Date</th>
                <th>Brand</th>
                <th>Operation</th>
            </tr>
            <c:forEach var="toy" items="${list}">
                <tr>
                    <td>${toy.id}</td>
                    <td>${toy.name}</td>
                    <td style="text-align: right">
                        <fmt:formatNumber value="${toy.price}" type="currency" currencySymbol="$"/>
                    </td>
                    <td>
                        <fmt:formatDate value="${toy.expDate}" pattern="dd-MM-yyyy"/>
                    </td>
                    <td>${toy.brand}</td>
                    <td>
                        <a href="<c:url value="/toy/edit.do?id=${toy.id}"/>">Edit</a> | 
                        <a href="<c:url value="/toy/delete.do?id=${toy.id}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>