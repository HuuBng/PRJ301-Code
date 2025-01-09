<!DOCTYPE html>
<html>
    <head>
        <title>Calculator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Calculator</h1>
        <hr/>
        <form action="calculator2">
            <!-- calculator1: la URL pattern cua servlet de xu ly form-->
            Number 1: <br/>
            <input type="text" name="num1" value="${param.num1}" /> <br/>
            Number 2: <br/>
            <input type="text" name="num2" value="${param.num2}" /> <br/>
            <input type="submit" name="op" value="Add" />
            <input type="submit" name="op" value="Minus" />
            <input type="submit" name="op" value="Mult" />
            <input type="submit" name="op" value="Div" />
            <input type="reset" value="Reset" />
        </form>
        <!-- Lay attribute tu doi tuong request -->
        Result: ${result}
        
    </body>
</html>
