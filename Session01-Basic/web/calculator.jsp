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
            <button type="submit" name="op" value="add">Add</button>
            <button type="submit" name="op" value="sub">Sub</button>
            <button type="submit" name="op" value="mul">Mul</button>
            <button type="submit" name="op" value="div">Div</button>
            <input type="reset" value="Reset" />
        </form>
        <!-- Lay attribute tu doi tuong request -->
        Result: ${result}
        
    </body>
</html>
