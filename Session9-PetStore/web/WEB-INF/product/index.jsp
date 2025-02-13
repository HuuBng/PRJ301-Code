<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <c:forEach var="product" items="${list}" >
        <div class="col-sm-4">
            Id: ${product.id} <br/>
            Description: ${product.description} <br/>
            Price: ${product.price} <br/>
            Discount: ${product.discount} <br/>
            Category Id: ${product.categoryId} <br/>
        </div>
    </c:forEach>
</div>
