<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Toy</h1>
        <hr/>
        <form action="toy">
            Are you sure to delete this toy with id = ${param.id};
            <input type="hidden" name="action" value="delete_handler" />
            <button type="submit" name="op" value="yes" >Yes</button>
            <button type="submit" name="op" value="no" >No</button>
        </form>
    </body>
</html>
