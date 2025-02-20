<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-sm-12">

        <a href="<c:url value="/?page=1"/>" class="btn btn-sm btn-primary" title="First">
            <i class="bi bi-caret-left-fill"></i>
        </a>

        <a href="<c:url value="/?page=${page-1}"/>" class="btn btn-sm btn-primary" title="Previous">
            <i class="bi bi-caret-left"></i>
        </a>
        <a href="<c:url value="/?page=${page+1}"/>" class="btn btn-sm btn-primary" title="Next">
            <i class="bi bi-caret-right"></i>
        </a>

        <a href="<c:url value="/?page=${totalPage}"/>" class="btn btn-sm btn-primary" title="Last">
            <i class="bi bi-caret-right-fill"></i>
        </a>
    </div>
</div>

<div class="row">
    <c:forEach var="product" items="${list}" >
        <div class="col-sm-4 mt-3 mb-3">
            Id: ${product.id} <br/>
            Description: ${product.description} <br/>
            Price: <fmt:formatNumber value="${product.price}" type="currency" currencySymbol="$"/> <br/>
            Discount: <fmt:formatNumber value="${product.discount}" type="percent"/> <br/>
            Category Id: ${product.categoryId} <br/>
            <img src="<c:url value="/products/${product.id}.jpg"/>" width="100%"/>
        </div>
    </c:forEach>
</div>
