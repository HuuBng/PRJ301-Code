<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Toy</h1>
        <hr/>
        <form action="toy">
            Id: <br/>
            <input type="text" name="id"/> <br/>
            Name: <br/>
            <input type="text" name="name"/> <br/>
            Price: <br/>
            <input type="text" name="price"/> <br/>
            Expired Date: <br/>
            <input type="date" name="expDate"/> <br/>
            Brand: <br/>
            <input type="text" name="brand"/> <br/>
            <input type="hidden" name="action" value="create_handler" />
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
    </body>
</html>
