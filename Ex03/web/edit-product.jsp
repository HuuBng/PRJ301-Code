<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
    </head>
    <body>
        <h1>Edit Product</h1>
        <hr/>
        <form action="<c:url value="/product/edit_handler.do"/>">
            Id: <br/>
            <!-- Show id-->
            <input type="text" value="${product.id}" disabled=""/>
            <!-- Hidden id to send to server-->
            <input type="hidden" name="id" value="${product.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value="${param.name!=null?param.name:product.name}"/> <br/>
            Price: <br/>
            <input type="text" name="price" value="${param.price!=null?param.price:product.price}"/> <br/>
            Expired Date: <br/>
            <input type="date" name="expDate" value="${param.expDate!=null?param.expDate:product.expDate}"/> <br/>
            <button type="submit" name="op" value="update" >Update</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
</html>
