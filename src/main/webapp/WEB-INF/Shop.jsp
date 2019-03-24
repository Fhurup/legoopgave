<%-- 
    Document   : Shop
    Created on : 23-Mar-2019, 15:34:36
    Author     : frederik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Just get a house</title>
    </head>
    <body>

        <% String user = (String) session.getAttribute("email");
            out.print("Welcome: " + user); %>

        <form name="placeOrder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="placeOrder">
            Choose dimensions for your Lego house:<br>
            <br>
            Length:<br>
            <input type="text" name= "l" value="0">
            <br>
            Width:<br>
            <input type="text" name="w" value="0">
            <br>
            Height:<br>
            <input type="text" name="h" value="0">
            <br>
            <input type="submit" value="Submit">
        </form>
        <form name="getOrders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="getOrders">
            <br>
            <br>
            <br>
            See orders:<br>
            <br>
            <input type="submit" value="See Orders">
            <br>
        </form>
        <% String error = (String) request.getAttribute( "error");
        if ( error != null) { 
            out.println("<H2>Error!!</h2>");
            out.println(error);
        }
        %>
    </body>
</html>
