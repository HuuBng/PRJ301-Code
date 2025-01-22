<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Toy</title>
    </head>
    <body>
        <h1>Edit Toy</h1>
        <hr/>
        <form action="toy">
            Id: <br/>
            <!-- Show id-->
            <input type="text" value="${toy.id}" disabled=""/>
            <!-- Hidden id to send to server-->
            <input type="hidden" name="id" value="${toy.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value="${param.name!=null?param.name:toy.name}"/> <br/>
            Price: <br/>
            <input type="text" name="price" value="${param.price!=null?param.price:toy.price}"/> <br/>
            Expired Date: <br/>
            <input type="date" name="expDate" value="${param.expDate!=null?param.expDate:toy.expDate}"/> <br/>
            Brand: <br/>
            <input type="text" name="brand" value="${param.brand!=null?param.brand:toy.brand}"/> <br/>
            <input type="hidden" name="action" value="edit_handler" />
            <button type="submit" name="op" value="update" >Update</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
</html>
