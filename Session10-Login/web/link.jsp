<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
Welcome ${account.fullName} | <a href="<c:url value="/user/logout.do"/>">Logout</a>
