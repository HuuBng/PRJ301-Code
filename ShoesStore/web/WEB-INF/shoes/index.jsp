<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/layouts/topLayout.jsp" />

<div class="row">
    <div class="col-sm-12">
        <c:if test="${account.role=='ADMIN'}">
            <a href="<c:url value="/shoes/create.do"/>">Create shoes</a>  |  
        </c:if>

        <c:if test="${not empty account}" >
            <a href="<c:url value="/order/index.do"/>">Order Status</a>

        </c:if>

        <div class="float-end">
            <a href="<c:url value="/?page=1"/>" class="btn btn-sm btn-primary ${page <=1?"disabled":""}" title="First">
                <i class="bi bi-caret-left-fill"></i>
            </a>
            <a href="<c:url value="/?page=${page-1}"/>" class="btn btn-sm btn-primary ${page <=1?"disabled":""}" title="Previous">
                <i class="bi bi-caret-left"></i>
            </a>
            <a href="<c:url value="/?page=${page+1}"/>" class="btn btn-sm btn-primary ${page >=totalPage?"disabled":""}" title="Next">
                <i class="bi bi-caret-right"></i>
            </a>
            <a href="<c:url value="/?page=${totalPage}"/>" class="btn btn-sm btn-primary ${page >=totalPage?"disabled":""}" title="Last">
                <i class="bi bi-caret-right-fill"></i>
            </a>
            Page: ${page} / ${totalPage}
        </div>
    </div>
</div>

<c:set var="list2" value="${list}" scope="request" />
<jsp:include page="/WEB-INF/layouts/display.jsp" />

