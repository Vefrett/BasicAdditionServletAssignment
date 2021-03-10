<%-- 
    Document   : addtwo
    Created on : Mar 4, 2021, 4:01:47 PM
    Author     : Gabrielle
--%>



<%@page import="java.math.BigDecimal"%>
<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- any info you get from the request will return in the form of a string
        At the beginning here these two nums will return null
        Could take two variables and use an expression in the form tags so the
        values display as text in the form. To do that there is a value attribute you
        can add in input area below. If they are empty consider them as zero.
        line 30 our input 
-->
<%
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String message = "";

    if (num1 == null || num1.equals(" ")) {
        num1 = "0";
    }
    if (num2 == null || num1.equals(" ")) {
        num2 = "0";
    }

    BigDecimal value1 = new BigDecimal("0");
    String error1 = "";
    try {
        value1 = new BigDecimal(num1);
    } catch (NumberFormatException e) {
        error1 = "Not a number";
    }

    BigDecimal value2 = BigDecimal.ZERO;
    String error2 = "";
    try {
        value2 = new BigDecimal(num2);
    } catch (NumberFormatException e) {
        error2 = "Not a number";
    }

    if (error1.equals("Not a number") && error2.equals("Not a number")
            || error1.equals("Not a number") && error2.equals("") || error1.equals("")
            && error2.equals("Not a number")) {
        message = "There is no sum.";
        num1 = "0";
        num2 = "0";
    }

    BigDecimal sum = BigDecimal.ZERO;
    if (error1.equals("") && error2.equals("")) {
        sum = value1.add(value2);
        message = value1 + " + " + value2 + " = " + sum;

    }


%>
<!DOCTYPE html>
<html lang="en-us"> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link href="styles/main.css" rel="stylesheet" />
    </head>
    <body>
        <header>
            <h1>Hello Guest!</h1>
            <p>Enter two numbers to calculate their sum.</p>            
        </header>
        <form action="addTwo.jsp" method="POST">
            <label for="num1">Enter your number:</label><br>
            <input type="text" name="num1" id="num1" value="<%= num1%>" > <%= error1%><br><br>

            <label for="num2">Enter your number</label><br>
            <input type="text" name="num2" id="num2" value="<%= num2%>" > <%= error2%> <br><br>

            <input type="submit" value="Submit">

        </form>
        <p>Result: <%= message%></p>
    </body>
</html>
