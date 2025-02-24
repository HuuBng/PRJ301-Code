<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html data-bs-theme="">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet Store</title>
        <link href="<c:url value="css/stylesheet.css"/>" rel="stylesheet"/>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12 header">
                    <%--header--%>
                    <h1 class="title" style="color: blue">Pet Store</h1>
                    <p class="float-end">
                        <a href="<c:url value="/cart/index.do" />">
                            <i class="bi bi-cart2"></i> ${cart.total}
                        </a>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <%--content--%>
                    <jsp:include page="/WEB-INF/${controller}/${action}.jsp" />
                </div>
            </div>

            <div class="row">
                <div class="col-md-12 footer">
                    <%--footer--%>
                    Copyright &COPY; by FPT students
                </div>
            </div>
        </div>



    </body>
</html>
