<%-- 
    Document   : calculator
    Created on : 29-Sep-2020, 12:45:57 AM
    Author     : StormCloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <body>
        <h1>Calculator</h1>
        <form action="calc" method="POST">
            <input type="number" name="num1" value="${number1}"/>
            <input type="number" name="num2" value="${number2}"/>
            <br>
            <input type="submit" name="action" value="+"/>
            <input type="submit" name="action" value="-"/>
            <input type="submit" name="action" value="*"/>
            <input type="submit" name="action" value="/"/>
        </form>
        <div>
            
            <p>
                Equals =  ${result};
            </p>
            
            <a href="calcage">go to age calculator.</a>
            
        </div>
    </body>
</html>
