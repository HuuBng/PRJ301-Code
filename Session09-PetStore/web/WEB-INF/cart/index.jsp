<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-stripes">
    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.product.description}</td>
            <td>${item.product.price}</td>
            <td>${item.product.newPrice}</td>
            <td>${item.quantity}</td>
            <td>${item.cost}</td>
        </tr>
    </c:forEach>
</table>
