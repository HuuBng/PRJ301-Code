<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-stripe">
    <tr>
        <td>No.</td>
        <td>Image</td>
        <td>Id</td>
        <td>Description</td>
        <td style="text-align: right">Old Price</td>
        <td style="text-align: right">New Price</td>
        <td style="text-align: right">Quantity</td>
        <td style="text-align: right">Cost</td>
    </tr>
    <c:forEach var="item" items="${cart.items}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><img src="<c:url value="/products/${item.id}.jpg"/>" height="60px"/></td>
            <td>${item.id}</td>
            <td>${item.product.description}</td>
            <td style="text-align: right">
                <fmt:formatNumber value="${item.product.price}" type="currency" currencySymbol="$"/>
            </td>
            <td style="text-align: right">
                <fmt:formatNumber value="${item.product.newPrice}" type="currency" currencySymbol="$"/>
            </td>
            <td style="text-align: right">
                <fmt:formatNumber value="${item.quantity}" type="number"/>
            </td>
            <td style="text-align: right">                
                <fmt:formatNumber value="${item.cost}" type="currency" currencySymbol="$"/>
            </td>
        </tr>
    </c:forEach>
</table>
