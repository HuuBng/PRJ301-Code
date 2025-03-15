<%-- 
    Document   : create
    Created on : Feb 1, 2025, 8:46:30 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Create Shoes</title>   
        <h1>Create Shoes</h1>
        <hr/>
        <form action="<c:url value="/shoes/create_handler.do"/>">
            Id: <br/>
            <input type="text" name="id" value="${param.id}" disabled=""/> <br/>
            Name: <br/>
            <input type="text" name="name" value="${param.name}"/> <br/>
             Brand: <br/>
            <input type="text" name="brand" value="${param.brand}"/> <br/>
             Category: <br/>
            <input type="text" name="category" value="${param.category}"/> <br/>
             Size(ghi them dau phay cho nhieu size khac nhau): <br/>
            <input type="text" name="size" value="${param.size}"/> <br/>
            Price: <br/>
            <input type="text" name="price" value="${param.price}"/> <br/>
            Discount(discount nam tu 0 toi 100): <br/>
            <input type="text" name="discount" value="${param.discount}"/>
            <br/><br/>
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style="color: red">${message}</i>
   
