<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brand CRUD</title>
    </head>
    <body>
        <h1>Brand Crud</h1>
        <hr/>
        <a href="brand?action=create">Create New</a><br/>
        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Operation</th>
            </tr>
            <c:forEach var="brand" items="${list}">
                <tr>
                    <td>${brand.id}</td>
                    <td>${brand.name}</td>
                    <td>
                        <a href="toy?action=edit&id=${brand.id}">Edit</a> | 
                        <a href="toy?action=delete&id=${brand.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
