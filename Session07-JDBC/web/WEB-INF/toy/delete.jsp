<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Delete Toy</h1>
<hr/>
<form action="<c:url value="/toy/delete_handler.do"/>">
    Are you sure to delete this toy with id = ${param.id};
    <input type="hidden" name="id" value="${param.id}" />
    <button type="submit" name="op" value="yes" >Yes</button>
    <button type="submit" name="op" value="no" >No</button>
</form>
