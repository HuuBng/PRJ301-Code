<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:forward page="/product/index.do?page=1" />

<%--
index.jsp --> FrontController --> ProductController
          --> layouts/main.jsp --> include /product/index.jsp
--%>