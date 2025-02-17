<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>User</h3>
<a href="<c:url value="/user/register.do" />">Register</a><br/>
<a href="<c:url value="/user/login.do" />">Login</a><br/>
<a href="<c:url value="/user/logout.do" />">Logout</a><br/>

<h3>Product</h3>
<a href="<c:url value="/product/create.do" />">Create</a><br/>
<a href="<c:url value="/product/edit.do" />">Edit</a><br/>
<a href="<c:url value="/product/delete.do" />">Delete</a><br/>