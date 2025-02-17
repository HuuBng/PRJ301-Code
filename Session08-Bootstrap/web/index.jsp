<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:forward page="/toy/index.do" />

<%--
index.jsp --> FrontController --> ToyController
          --> layouts/main.jsp --> include /toy/index.jsp
--%>