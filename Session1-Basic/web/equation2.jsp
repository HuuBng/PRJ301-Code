<!DOCTYPE html>
<html>
    <head>
        <title>Equation</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Equation: ax<sup>2</sup> + bx + c = 0</h1>
        <hr/>
        <form action="equation2">
            <!-- calculator1: la URL pattern cua servlet de xu ly form-->
            Factor a: <br/>
            <input type="text" name="a" value="${param.a}" /> <br/>
            Factor b: <br/>
            <input type="text" name="b" value="${param.b}" /> <br/>
            Factor c: <br/>
            <input type="text" name="c" value="${param.c}" /> <br/>
            <input type="submit" name="op" value="Solve" />
        </form>
        <!-- Lay attribute tu doi tuong request -->
        Result: ${result}
        
    </body>
</html>
