<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Brand</title>
    </head>
    <body>
        <h1>Edit Brand</h1>
        <hr/>
        <form action="brand">
            Id: <br/>
            <!-- Show id-->
            <input type="text" value="${brand.id}" disabled=""/>
            <!-- Hidden id to send to server-->
            <input type="hidden" name="id" value="${brand.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value="${param.name!=null?param.name:brand.name}"/> <br/>
            <input type="hidden" name="action" value="edit_handler" />
            <button type="submit" name="op" value="update" >Update</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
</html>
