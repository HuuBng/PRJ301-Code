<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Calculator</title>
    </head>
    <body>
        <h1>Calculator</h1>
        <hr/>
        <div class="div-container">
            <div class="div">
                <h2>Equation: ax + b = 0</h2>
                <form action="calculator">
                    Factor a: <br/>
                    <input type="text" name="a1" value="${param.a1}" /> <br/>
                    Factor b: <br/>
                    <input type="text" name="b1" value="${param.b1}" /> <br/>
                    <button type="submit" name="op" value="1"> Solve </button>
                </form>
            </div>

            <div class="div">
                <h2>Equation: ax<sup>2</sup> + bx + c = 0</h2>
                <form action="calculator">
                    Factor a: <br/>
                    <input type="text" name="a2" value="${param.a2}" /> <br/>
                    Factor b: <br/>
                    <input type="text" name="b2" value="${param.b2}" /> <br/>
                    Factor c: <br/>
                    <input type="text" name="c2" value="${param.c2}" /> <br/>
                    <button type="submit" name="op" value="2"> Solve </button>
                </form>
            </div></div>
                    
        <p>Result: ${model.result}</p>

    </body>
</html>
